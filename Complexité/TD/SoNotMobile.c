#include <stdio.h>

typedef struct node {
  int w, d;
  struct node *left, *right;
} treenode;

treenode *root;

void init(treenode ** root){
    treenode *tmp;
    tmp = (treenode *)malloc(sizeof(treenode));
    tmp->w = 0;
    tmp->d = 0;
    tmp->left = NULL;
    tmp->right = NULL;
	*root = tmp;
}

void make_tree(treenode **root){
	int w1, d1, w2, d2;
	scanf("%d%d%d%d", &w1, &d1, &w2, &d2);
	
	treenode *tmp_left, *tmp_right;
	
    tmp_left = (treenode *)malloc(sizeof(treenode));
    tmp_left->w = w1;
    tmp_left->d = d1;
    tmp_left->left = NULL;
    tmp_left->right = NULL;
   	
    tmp_right = (treenode *)malloc(sizeof(treenode));
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
void postOrder(treenode *root){
  if (root != NULL){
    postOrder(root->left);
	postOrder(root->right);
	printf("%d ", root->w);
  }
}

int main(){
	init(&root);
	make_tree(&root);
	postOrder(root);
	return 0;
}
