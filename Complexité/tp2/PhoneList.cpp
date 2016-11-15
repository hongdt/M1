#include<iostream>
#include<algorithm>
using namespace std;
/*
	- Pour chaque le cas de test, je vais trier le tableau de num�ro de t�l�phone utilisant
	  la fonction "sort" dans la biblioth�que "algorithme".
	- Et puis, je vais comparer deux num�ros de t�l�phone cons�cutifs dans ce tableau. 
	  Si il a un num�ro de t�l�phone qui est substring d'autre , la boucle s'arr�te 
	  et l'�cran va afficher "NO". Si non, la boucle continue. Si on peut parcourir tous les num�ros de t�l�phone,
	  l'�cran va afficher "YES".
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
