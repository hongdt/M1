#include<iostream>
#include<algorithm>
using namespace std;
/*
	- Le semis qui a le plus de temps pour pousser à pleine maturité a chosi premier.
	- Après planter tous les semis , pour chaque semis, je calcule le temps restant pour pousser à pleine maturité a chosi premier.
	- Et puis je choisis le semis qui a le plus de temps restant. Le résultat est ce temps plus N plus 1 (N est le nombre de semis).
	- T(n) = max(O(n), O(nlog(n))) .
*/
int main(){
	int N;
	cin>>N;
	int tree[N], day = N - 1;
	for(int i = 0; i < N; i++){
		cin>>tree[i];
	}
	sort(tree, tree + N);
	for(int i = N - 1; i > 0; i--){
		tree[i] = tree[i] - i;
	}
	sort(tree, tree + N);
	cout<<tree[N - 1] + N + 1; 
	return 0;
}
