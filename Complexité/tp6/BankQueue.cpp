#include<iostream>
using namespace std;
/*
	- Il y a T minutes correspondant T slot.
	- Je vais chosir T personnes pour T slot utilisant l'algorthme glouton comme suivant :
		+ Considerer la personne qui a le plus du montant de la trésorerie.
		+ Choisir un slot pour cette personne si le temps de cette personne >= le temps de slot 
		et puis plus son montant de la trésorerie avec la somme de montant de la trésorerie.
	- T(N) = max(O(N*N), O(N*T))
*/
int main(){
	int N, T;
	cin>>N>>T;
	int c[N], t[N], slot[T];
	for(int i = 0; i < T; i++){
		slot[i] = true;
	}
	for(int i = 0; i < N; i++){
		cin>>c[i]>>t[i];
	}
	for(int i = 0; i < N; i++){
		for(int j = i + 1; j < N; j++){
			if(c[i] > c[j]){
				int tmp_c, tmp_t;
				tmp_c = c[i];
				c[i] = c[j];
				c[j] = tmp_c;
				
				tmp_t = t[i];
				t[i] = t[j];
				t[j] = tmp_t;
			}
		}
	}
	int sum = 0;
	for(int i = N - 1; i >= 0; i--){
		for(int j = T - 1; j >= 0; j-- ){
			if(slot[j]&&t[i] >= j){
				slot[j] = false;
				sum += c[i];
				break;
			}
		}
	}
	cout<<sum<<endl;
	return 0;
}
