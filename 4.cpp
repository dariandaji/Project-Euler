#include<iostream>
#include <bits/stdc++.h>
using namespace std;

int palindrome(int n)
{
	int k,l=0;
	while(n!=0)
	{
		k=n%10;
		l = l*10+k;
		n=n/10;
	}
	return l;
}

int main()
{
	int i,j,n,m;
	int max=0;
	for(i=999;i>=100;i--)
	{
		for(j=999;j>=100;j--)
		{
			n=i*j;
			m=palindrome(n);
			
			if(m==n && m>max)
				max = m;
		}
	}
	cout<<max;
	return 0;
}
			
