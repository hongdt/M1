#include<iostream>
#include<algorithm>
using namespace std;
/*
	- Pour chaque le cas de test, je vais trier le tableau de numéro de téléphone utilisant
	  la fonction "sort" dans la bibliothèque "algorithme".
	- Et puis, je vais comparer deux numéros de téléphone consécutifs dans ce tableau. 
	  Si il a un numéro de téléphone qui est substring d'autre , la boucle s'arrête 
	  et l'écran va afficher "NO". Si non, la boucle continue. Si on peut parcourir tous les numéros de téléphone,
	  l'écran va afficher "YES".
	- T(n) = max(O(n), O(nlog(n))) .
*/
bool check(string s1, string s2){
	int length = 0;
	if(s1.length() < s2.length()){
		length = s1.length();
	}else{
		length = s2.length();
	}
	for(int i = 0; i < length; i++){
		if(s1[i] != s2[i])
			return true;
	}
	return false;
}

int main(){
	int numberTest;
	cin>>numberTest;
	while(numberTest--){
		int n;
		cin>>n;
		string phone[n];
		for(int i = 0; i < n; i++){
			cin>>phone[i];
		}
		sort(phone, phone + n);
		bool ok = true;
		for(int i = 0; i < n - 1; i++){
			if(!check(phone[i], phone[i + 1])){
				ok = false;
				break;
			}
		}
		if(ok){
			cout<<"YES \n";
		}else{
			cout<<"NO \n";
		}
	}
}
