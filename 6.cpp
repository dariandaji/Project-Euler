#include<iostream>
#include<math.h>


using namespace std;
int main()
{
	int sum_sq=0, sq_sum=0;
	int i;
	
	for(i=1;i<=100;i++)
	{
		sum_sq+=pow(i,2);
		sq_sum+=i;
	}
	int diff;
	diff = pow(sq_sum,2) - sum_sq;
	cout<<"\n"<<diff<<"\n";
	return 0;
}
