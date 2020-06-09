#include<iostream>
using namespace std;
int main()
{
	int i=0,j=1,k;
	int sum=0;
	while(k<=4000000)
	{
		k=i+j;
		if(k%2==0)
			sum+=k;
		i=j;
		j=k;
	}
	
	cout<<"\n"<<sum<<"\n";
	return 0;
}
