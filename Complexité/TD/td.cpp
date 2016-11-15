#include<iostream>
#include<stdio.h>
#include<stdlib.h>
using namespace std;

struct node{
	int w;
	int d;
	struct node *left;
	struct node *right;
};

typedef struct node treenode;

/*treenode getNode(){
	treenode p;
	p = (treenode)calloc(1, sizeof(struct node));
	return p;
}*/

void init(treenode *root){
	root->d = 0;
	root->w = 0;
	root->left = NULL;
	root->right = NULL;
}

treenode makeNode(int _w, int _d){
	treenode p;
	//p = getNode();
	p.w = _w;
	p.d = _d;
	p.left = NULL;
	p.right = NULL;
	return p;
}

void postOrder(node *root){
	if(root != NULL){
		postOrder(root->left);
		postOrder(root->right);
		cout<<root->w<<endl;
	}
}

void makeTree(node &root){
    int w1,d1,w2,d2;
    cin>>w1>>d1>>w2>>d2;
    
    node node_left, node_right;
	node_left = makeNode(w1, d1);
	node_right = makeNode(w2, d2);
	
	root.left = &node_left;
	root.right = &node_right;
	
    if(w1 == 0) makeTree(node_left);
    if(w2 == 0) makeTree(node_right);
}

int main(){
	int numberTest;
    cin>>numberTest;
    while(numberTest--)
    {
    	node root;
    	init(&root);
    	makeTree(root);
    	
    	postOrder(&root);
        //if(solve(w)) cout<<"YES"<<endl;
        //else cout<<"NO"<<endl;
        if(numberTest) cout<<endl;
    }
    return 0;
}
