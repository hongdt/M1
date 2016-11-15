/*
    Program's name: Digit Sum
    Author: Menh Bui Van
    Email: menhict@gmail.com
    Date: 11/07/2016
*/
#include <iostream>
#include <unordered_map>
using namespace std;
int sumDigitsI(long n);
int sumDigitsII(long n);
long long sumDigitInRangeByBruteForce(long &a, long &b);
long long sumDigitInRangeByDynamic(long &a, long &b);
long long sumRange(long n);
int main(){
    int testCases;
    cin>>testCases;
    while(testCases--){
        long a, b;
        cin>>a>>b;
        cout<<sumDigitInRangeByDynamic(a,b)<<'\n';
    }
    return 0;
}


long long sumDigitInRangeByBruteForce(long &a, long &b){
	long long result=0;
	for(long i=a;i<=b;++i)
		result+=sumDigitsI(i);
	return result;
}

int sumDigitsI(long n)
{
    long result;
    if(n < 10)
        return n;
    result=n% 10 + sumDigitsI(n / 10);
    return result;
}









unordered_map <long,long> sumDigitMap;
int sumDigitsII(long n)
{
    long result;
    if(n < 10)
        return n;
    if(sumDigitMap.find(n)!=sumDigitMap.end())
        return sumDigitMap[n];
    result=n% 10 + sumDigitsII(n / 10);
    sumDigitMap[n]=result;
    return result;
}








long long sumDigitInRangeByDynamic(long &a, long &b){
	return sumRange(b+1)-sumRange(a);
}


unordered_map <long long,long long> sumRangeMap;
long long sumRange(long n) {
    long long result;
    if (sumRangeMap.find(n) != sumRangeMap.end())
        return sumRangeMap[n];
    if (n < 10) result = n*(n-1)/2;
    else result = (n/10) * 45 + sumRange(n/10) * 10
            + sumDigitsII(n/10) * (n%10) + sumRange(n%10);
    sumRangeMap[n] = result;
    return result;
}
