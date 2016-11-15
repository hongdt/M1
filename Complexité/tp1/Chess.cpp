#include<iostream>
#include<string>
using namespace std;

void change(char *a, int *b){
	switch(*a){
			case 'A':
				*b = 8;
				break;
			case 'B':
				*b = 7;
				break;
			case 'C':
				*b = 6;
				break;
			case 'D':
				*b = 5;
				break;
			case 'E':
				*b = 4;
				break;
			case 'F':
				*b = 3;
				break;
			case 'G':
				*b = 2;
				break;
			case 'H':
				*b = 1;
				break;
		}
}

int main(){
	int numberTest;
	int x1, x2;
	char _x1, _x2;
	int y1, y2;
	
	cin>>numberTest;
	while(numberTest--){
		cin>>_x1>>y1>>_x2>>y2;
		change(&_x1, &x1);
		change(&_x2, &x2);
		if((x1 + y1 + x2 + y2) % 2 != 0){
			cout<<"Impossible \n";
		}else{
			if((x1 == x2) && (y1 == y2)){
				cout<<0<<" "<<_x1<<" "<<y1<<endl;
			}else{
				if((x1 + y1 == x2 + y2) || (x1 - y1 == x2 - y2)){
					cout<<1<<" "<<_x1<<" "<<y1<<" "<<_x2<<" "<<y2<<endl;
				}else{
					int s1 = x1 + y1, h1 = x1 - y1;
					int s2 = x2 + y2, h2 = x2 - y2;
					int x, y;
					char _x;
					x = (s2 + h1)/2;
					y = (s2 - h1)/2;
					if(x > 0 && x < 9 && y > 0 && y < 9);
					else{
						x = (s1 + h2)/2;
						y = (s1 - h2)/2;
					}
					//cout<<x<<" test "<<y<<" "<<x1<<" "<<s1<<" "<<h1<<" "<<x2<<" "<<s2<<" "<<h2<<endl;
					switch(x){
						case 8:
							_x = 'A';
							break;
						case 7:
							_x = 'B';
							break;
						case 6:
							_x = 'C';
							break;
						case 5:
							_x = 'D';
							break;
						case 4:
							_x = 'E';
							break;
						case 3:
							_x = 'F';
							break;
						case 2:
							_x = 'G';
							break;
						case 1:
							_x = 'H';
							break;
					}
					cout<<2<<" "<<_x1<<" "<<y1<<" "<<_x<<" "<<y<<" "<<_x2<<" "<<y2<<endl;
				}
			}
		}
	}
	return 0;
}
