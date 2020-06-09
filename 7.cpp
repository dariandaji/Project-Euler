#include<stdio.h>
#include<iostream>
using namespace std;

int main()
{
	int cnt=4;
	int n=11;
	int flag=0;
	int i;
	while(cnt!=10001)
	{
		flag=1;
		for(i=3;i<=n/2;i++)
		{
			if(n%i==0)
			{
				flag=0;
				break;
			}
		}
		n+=2;
		if(flag==1)	cnt++;
	}
	cout<<"\n"<<n-2<<"\n";
	return 0;
}	
		
