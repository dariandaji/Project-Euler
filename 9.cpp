#include<iostream>
#include<math.h>
using namespace std;
int main()
{
	int a,b,c;
	long long product;
	for(c=1;c<1000;c++)
		for(b=1;b<c;b++)
			for(a=1;a<b;a++)
				if((a+b+c==1000) && (pow(a,2)+pow(b,2)==pow(c,2)))
				{	
					product=a*b*c;
					cout<<"Product: "<<product<<endl;
					break;
				}
				
	return 0;
}						
			
			
			
