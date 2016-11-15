#include <iostream>
#include<stdio.h>
#include<stdlib.h>
#include<queue>
#include<vector>
#include<string.h>
using namespace std;
/*
	- Deux files d'attente prioritaire, un grand tas de racines avant les n / 2 éléments de l'enregistrement, 
	  un enregistrement des éléments restants de racines petit tas.
	- Utilse 
		priority_queue <int> fron pour stockager de vecteur de priorité de file d'attente par défaut et un grand tas de racines
		priority_queue <int, vector <int>, plus <int >> rear : plus <int> peut en faire une petite racine de tas.
	- T(n) = O(n)
*/

int main()
{
    char s[10000];
    int g,h,num1=0,num2=0;
    priority_queue<int> fron;
    priority_queue<int, vector<int>, greater<int> > rear;
    while (scanf("%s",s)!=EOF){
        if (strcmp(s,"#")) {
            g=atoi(s);
            if (num2==0 || g>=rear.top()) {rear.push(g);num2++;}else {fron.push(g);num1++;}
            if (num1>num2){
                rear.push(fron.top());num2++;
                fron.pop();num1--;
            }
            if (num2>=num1+2){
                fron.push(rear.top());num1++;
                rear.pop();num2--;
            }
        }else{
            printf("%d\n",rear.top());
            rear.pop();num2--;
            if (num1>num2) {
                h=fron.top();
                fron.pop();num1--;
                rear.push(h);num2++;
            }
        }
    }
    return 0;
}
