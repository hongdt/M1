#include<iostream>
/*Utiliser 2 array:
Premiere array pour stocker les numeros de demande des equipes qui ont les kayak endommages
Deuxieme array pour stocker les numeros de demande des equipes qui ont les kayak reserves
* Utiliser 2 loop pour parcourir 2 array
* Si le numero de demande de l'equipe qui a un kayak reserve = le numero de demande de l'equipe qui a un kayak endomage + 1
ou le numero de demande de l'equipe qui a un kayak endomage - 1
=> Nombre des equipes qui ne peuvent pas participer au concour diminue 1
* Car chaque equipe qui a un kayak reserve peut pret un kayak au un equipe qui a un kayak endomage,
il faut changer le numero de demande de l'equipe preteur
* T(n) = O(n2)
*/
using namespace std;
int main(){
	int numberKayak;
	int numberKayakDamaged;
	int numberKayaKReserve;
	
	cin>>numberKayak>>numberKayakDamaged>>numberKayaKReserve;
	
	int kayakDamagedNumber[numberKayakDamaged];
	int kayakReserveNumber[numberKayaKReserve];
	int count = numberKayakDamaged;
	
	for(int i = 0 ; i < numberKayakDamaged ; i++){
		cin>>kayakDamagedNumber[i];
	}
	
	for(int j = 0 ; j < numberKayaKReserve ; j++){
		cin>>kayakReserveNumber[j];
	}
	
	for(int i = 0 ; i < numberKayakDamaged ; i++){
		int kayak = kayakDamagedNumber[i];
		for(int j = 0 ; j <numberKayaKReserve; j++){
			if(kayakReserveNumber[j]== kayak+1 || kayakReserveNumber[j]== kayak-1){
				count--;
				kayakReserveNumber[j] = -1;
				break;
			}
		}
	}
	cout<<count;
}
