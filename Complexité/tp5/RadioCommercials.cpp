#include<iostream>
using namespace std;
/*
	-	Pour chaque entrée, je vais calculer le profit correspondant.
	-	Puis, je vais appliquer l'algorithme de programme dynamique pour la sub-chaîne qui a la somme maximale.
	-	T(n) = O(n)	
*/
int main(){
	int N, P;
	cin>>N>>P;
	int a[N];
	for(int i = 0; i < N; i++){
		cin>>a[i];
		a[i] = a[i] - P;
	}
	int maxsum = 0;
    int sum = 0;
    for (int i = 0; i < N; ++i) {
        sum += a[i];
        if (sum < 0) sum = 0;
        if(sum > maxsum){
        	maxsum = sum;
        }
    }
    cout<<maxsum;
	return 0;
}
