#include<iostream>
#include<math.h>
using namespace std;
int main()
{
	int i,j;
	int	 num=0;
	int count=0;
	for(i=1;;i++)
	{
		num+=i;
		count=2;
		for(j=2;j<sqrt(num);j++)
			if(num%j==0) count+=2;
		if(count>=500)
			break;
	}
	cout<<"First triangle number with over 500 divisors is: "<<num<<endl;
	return 0;
}
