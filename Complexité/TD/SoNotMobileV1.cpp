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

struct node makeNode(int w0, int d0){
	struct node p;
	p = (struct node)calloc(1, sizeof(struct node));
	p.w = w0;
	p.d = d0;
	p.left = NULL;
	p.right = NULL;
	return p;
}

void makeTree(struct node root){
	int w1, d1, w2, d2;
	cin>>w1>>d1>>w2>>d2;
	
	struct node node_left, node_right;
	node_left = makeNode(w1, d1);
	node_right = makeNode(w2, d2);
	
	root.left = &node_left;
	root.right = &node_right;
	
	if(w1 == 0) makeTree(node_left);
	if(w2 == 0) makeTree(node_right);
}

void postOrder(struct node root){
	cout<<root.d<<endl;
	if(root.d != 0){
		postOrder(*root.left);
		postOrder(*root.right);
		cout<<"result "+root.w<<endl;
	}else{
		cout<<"empty \n";
	}
}

int main(){
	int numberTest;
	cin>>numberTest;
	while(numberTest--){
		struct node root, *tmp_root;
		root = makeNode(0, 0);
		tmp_root = &root;
		makeTree(*tmp_root);
		postOrder(root);
        if(numberTest) cout<<endl;
    }
    return 0;
}
