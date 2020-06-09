#include<iostream>
using namespace std;

int main()
{
	int i,j;
	int a[20][20];
	cout<<"Enter the array: \n";
	for(i=0;i<20;i++)
		for(j=0;j<20;j++)
			cin>>a[i][j];
			
	long pr=1,pc=1,pd=1,pd2=1,max=0;
	
	for(i=0;i<20;i++)
		for(j=0;j<20;j++)
		{
			pr=pc=pd=pd2=1;
			
			if(j<=16)
				pr=a[i][j]*a[i][j+1]*a[i][j+2]*a[i][j+3];
			if(i<=16)
				pc=a[i][j]*a[i+1][j]*a[i+2][j]*a[i+3][j];
			if(i<=16 && j<=16)
				pd=a[i][j]*a[i+1][j+1]*a[i+2][j+2]*a[i+3][j+3];
			if(i<=16 && j>=3)
				pd2=a[i][j]*a[i+1][j-1]*a[i+2][j-2]*a[i+3][j-3];
			
			if(pr>max) max=pr;
			if(pc>max) max=pc;
			if(pd>max) max=pd;
			if(pd2>max) max=pd2;
		}
	
	cout<<"\nGreatest Product: "<<max<<endl;
	return 0;
}
