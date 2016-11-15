#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
	int numberTest;
	cin>>numberTest;
	while(numberTest--){
		int price, N, _coin;
		cin>>price>>N;
		vector<int> coin;
		for(int i = 0; i < N; i++){
			cin>>_coin;
			coin.push_back(_coin);
		}
		sort(coin.begin(), coin.begin() + N);
		int sum_min = 10000, count = 0, sum_current = 0;
		while(!coin.empty()){
			if(sum_current >= price){
				if(sum_min > sum_current){
					sum_min = sum_current;
				}
				sum_current = 0;
				count = 0;
			}else{
				count++;
				sum_current += coin.front();
				coin.pop_back();
			}
			cout<<sum_min<<" "<<sum_current<<endl;
		}
		cout<<sum_min<<" "<<count - 1<<endl;
	}
	return 0;
}
