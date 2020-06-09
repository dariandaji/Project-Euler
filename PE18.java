import java.io.*;
import java.util.*;

class PE18 {
	static int max_sum=0;
	static int triangle[][] = new int[15][15];
	public static void main(String args[])throws IOException {
		Scanner sc = new Scanner(System.in);	
		
		
		int i,j;
		for(i=0;i<15;i++)
			for(j=0;j<15;j++)
				triangle[i][j]=0;
		
		
		System.out.println("Enter the values: ");
		
		for(i=0;i<15;i++) 
			for(j=0;j<=i;j++)
				triangle[i][j] = sc.nextInt();
			
	/*	System.out.println();
		for(i=0;i<15;i++) {
			for(j=0;j<=i;j++) {
				System.out.print(triangle[i][j]+" ");
			}
			System.out.println();
		} */
		
		
		
		iterate(0,0,0);
		System.out.println("The maximum path value is: "+max_sum);
				
		sc.close();
	}
	
	public static void iterate(int i, int j, int sum) {
		sum+=triangle[i][j];
		if(i==14) {	
			if(sum>max_sum) 
				max_sum = sum;
		}
		else {
			iterate(i+1,j,sum);
			iterate(i+1,j+1,sum);
		}
	}	
}
