#include<iostream>
#include<stack>
using namespace std;

typedef struct node {
  int w, d;
  struct node *left, *right;
} treenode;

treenode *root;
bool ok;

void init(treenode ** root){
    treenode *tmp;
    tmp = new treenode;
    tmp->w = 0;
    tmp->d = 0;
    tmp->left = NULL;
    tmp->right = NULL;
	*root = tmp;
	ok = true;
}

void make_tree(treenode **root){
	int w1, d1, w2, d2;
	
	//Lire l'entr�e 
	cin>>w1>>d1>>w2>>d2;
	
	treenode *tmp_left, *tmp_right;
	
	//Cr�er le noeud gauche
    tmp_left = new treenode;
    tmp_left->w = w1;
    tmp_left->d = d1;
    tmp_left->left = NULL;
    tmp_left->right = NULL;
   	
   	//Cr�er le noeud droit
    tmp_right = new treenode;
    tmp_right->w = w2;
    tmp_right->d = d2;
    tmp_right->left = NULL;
    tmp_right->right = NULL;
   	
   	//Attacher le noeud gauche et le noeud droit � le noeud courant
    (*root)->left = tmp_left;
    (*root)->right = tmp_right;
	
	//Si il y a le sous-mobile
    if(w1 == 0)
    	make_tree(&tmp_left);
    if(w2 == 0)
    	make_tree(&tmp_right);
}

stack<treenode> stack_tree;
//Parcours postfixe
void postOrder(treenode *root){
	if (root != NULL){
	    postOrder(root->left);
		postOrder(root->right);
		//Si il n'y a pas le sous-mobile, stocker le noeud dans stack
		if(root->w != 0){
			stack_tree.push(*root);
		}else{
			//Si il y a le sous-mobile, consid�rer l'�quilibre de sous-mobile
			treenode left, right;	
			
			//Obtenir la valeur de noeud gauche	dans le sous-mobile	
			right = stack_tree.top();
			stack_tree.pop();
			
			//Obtenir la valeur de noeud droit dans le sous-mobile	
			left = stack_tree.top();
			stack_tree.pop();
			
			//Mettre � jour	la valeur de noeud de parent		
			root->w = left.w + right.w;
			stack_tree.push(*root);
			
			//Consid�rer l'�quilibre de sous-mobile
			if((left.w * left.d) != (right.w * right.d)) ok = false;
		}
	}
}

int main(){
	int numberTest;
    cin>>numberTest;
    while(numberTest--){
		init(&root);
		make_tree(&root);
		postOrder(root);
		if(ok) cout<<"YES"<<endl;
		else cout<<"NO"<<endl;
        if(numberTest) cout<<endl;
    }
	return 0;
}
