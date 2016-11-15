#include <iostream>
#include <string>
#include <vector>
#include<iomanip>

using namespace std;
string welcome = "welcome to code jam";

int getByRecursion(string line, int n)
{
	if(n==welcome.size()) 
		return 1;
	int result=0;
	for(int i=0; i<line.size();++i){
		if(line[i]==welcome[n])
			result+=getByRecursion(line.substr(i+1,line.size()-i),n+1);
	}
	return result;
}

int main() {
	int numberTestCase;
	cin>> numberTestCase;
	cin.ignore();
	
	
	for(int i = 0; i < numberTestCase; i++) {
		string line;
		getline(cin, line);
		int num = 0;
		num = getByRecursion(line, 0);
        cout<<"Case #"<<i+1<<": "<<setfill('0')<<setw(4)<<num<<'\n';

    }
    return 0;
}
