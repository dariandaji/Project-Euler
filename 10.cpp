#include<iostream>
#include<math.h>
using namespace std;
int main()
{
	long long sum=2;
	int i,j,flag;
	for(i=3;i<2000000;i+=2)
	{
		flag=0;
		for(j=2;j<=sqrt(i);j++)
		{
			if(i%j==0)
			{
				flag=1;
				break;
			}
		}
		if(flag==0)
			sum+=i;
	}
	cout<<"Sum: "<<sum<<endl;
	return 0;
}
