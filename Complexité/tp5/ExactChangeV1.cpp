#include<iostream>
using namespace std;

int main(){
	int numberTest;
	cin>>numberTest;
	while(numberTest--){
		int price, N, _coin;
		cin>>price>>N;
		int coin[N];
		for(int i = 0; i < N; i++){
			cin>>coin[i];
		}
		int sum_min = 10000, count_min = 0, count_current = 0, sum_current = 0;
		for(int i = 0; i < N; i++){
			if(sum_current >= price){
				if(sum_min > sum_current){
					sum_min = sum_current;
					count_min = count_current;
				}
				sum_current = 0;
				count_current = 0;
			}else{
				count_current++;
				sum_current += coin[i];
			}
		}
		cout<<sum_min<<" "<<count_min<<endl;
	}
	return 0;
}
