#include<iostream>
using namespace std;
int main()
{
	int i;
	int n=1;
	int flag=0;
	while(flag==0)
	{
		for(i=2;i<21;i++)
		{
			if(n%i==0)
				flag=1;
			else
			{
				flag=0;
				break;
			}
		}
		if(flag==1) break;
		n++;
	}
	
	cout<<"\n"<<n<<"\n";
	return 0;
}


