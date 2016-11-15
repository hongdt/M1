#include<iostream>
#include<stack>
using namespace std;

typedef struct node {
  int w, d;
  struct node *left, *right;
} treenode;

treenode *root;

void init(treenode ** root){
    treenode *tmp;
    tmp = new treenode;
    tmp->w = 0;
    tmp->d = 0;
    tmp->left = NULL;
    tmp->right = NULL;
	*root = tmp;
}

void make_tree(treenode **root){
	int w1, d1, w2, d2;
	cin>>w1>>d1>>w2>>d2;
	
	treenode *tmp_left, *tmp_right;
	
    tmp_left = new treenode;
    tmp_left->w = w1;
    tmp_left->d = d1;
    tmp_left->left = NULL;
    tmp_left->right = NULL;
   	
    tmp_right = new treenode;
    tmp_right->w = w2;
    tmp_right->d = d2;
    tmp_right->left = NULL;
    tmp_right->right = NULL;
   	
    (*root)->left = tmp_left;
    (*root)->right = tmp_right;
	
    if(w1 == 0)
    	make_tree(&tmp_left);
    if(w2 == 0)
    	make_tree(&tmp_right);
}

stack<treenode> stack_tree;
bool postOrder(treenode *root){
  if (root != NULL){
    postOrder(root->left);
	postOrder(root->right);
	if(root->w != 0){
		stack_tree.push(*root);
	}else{
		treenode left, right;
		
		right = stack_tree.top();
		stack_tree.pop();
		
		left = stack_tree.top();
		stack_tree.pop();
		
		root->w = left.w + right.w;
		stack_tree.push(*root);
		
		if((left.w * left.d) == (right.w * right.d)) return true;
		else return false;
	}
  }
}

int main(){
	int numberTest;
    cin>>numberTest;
    while(numberTest--){
		init(&root);
		make_tree(&root);
		if(postOrder(root)) cout<<"YES \n";
		else cout<<"NO \n";
        if(numberTest) cout<<endl;
    }
	return 0;
}
