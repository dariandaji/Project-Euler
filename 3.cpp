#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include <bits/stdc++.h> 
using namespace std;
int main()
{
	long long i=600851475143;
	for(long long j=3;j<=sqrt(i);j=j+2)   //finds all factors
	{
		if(i%j==0)
			cout<<"\n"<<j;
	}
	return 0;
}
