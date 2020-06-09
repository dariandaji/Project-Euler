#include<iostream>
using namespace std;
int main()
{
	string a[100];
	int result;
	cout<<"Enter numbers: \n";
	for(int i=0;i<100;i++)
		cin>>a[i];
	
	
	int i,j=49,sum;
	int ch,cf=0;
	for(i=0;i<100;i++)
	{
		sum=0;
		ch=(int)(a[i].at(j)-48);
		sum+=ch;
		if(i==99)
		{
			sum+=cf;
			result+=(sum%10);
			cf = sum/10;
			j--;
		}
	}
	cout<<"Result: \n";	
	cout<<result;
	return 0;
}
