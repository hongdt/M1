#include<iostream>
using namespace std;
inline
void use_io_optimizations()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
}
int main(){
	use_io_optimizations();
	int numberTest;
	cin>>numberTest;
	for(int i = 0; i < numberTest; i++){
		long start, finish, sum = 0;
		cin>>start>>finish;
		for(int j = start; j <= finish; j++){
			if(j < 10){
				sum += j;
			}else{
				long num = j;
				while(num != 0){
					sum += num%10;
					num = num/10;
				}
			}
		}
		cout<<sum<<endl;
	}
}
