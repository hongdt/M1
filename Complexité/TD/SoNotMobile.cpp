#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include<algorithm>
using namespace std;
bool solve(int &w)
{
    int w1,d1,w2,d2;
    cin>>w1>>d1>>w2>>d2;
    bool left=true,right=true;
    if(w1==0) left=solve(w1);
    if(w2==0) right=solve(w2);
    w=w1+w2;
    return left && right && (d1*w1==d2*w2);
 
}
int main()
{
    int cas,w;
    cin>>cas;
    while(cas--)
    {
    	w=0;
        if(solve(w)) cout<<"YES"<<endl;
        else cout<<"NO"<<endl;
        if(cas) cout<<endl;
    }
    return 0;
}
