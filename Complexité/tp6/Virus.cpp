#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main(){
	string ADN_before, ADN_after;
	getline(cin, ADN_before);
	getline(cin, ADN_after);
	int len = min(ADN_before.length(), ADN_after.length()), min_len = 10001, count = 0;
	for(int i = 0; i < len; i++){
		if(ADN_before[i] != ADN_after[i]){
			count++;
		}else{
			if(count != 0){
				min_len = min(min_len, count);
			}
			count = 0;
		}
	}
	if(count != 0){
		min_len = min(min_len, count);
	}
	if(min_len == 10001) min_len = 0;
	cout<<min_len<<endl;
	return 0;
}
