import java.io.*;
import java.math.*;
import java.util.*;
class PE34 {
	public static void main(String args[])throws IOException {
		final long startTime = System.currentTimeMillis();
		int i,digit,n,r;
		long sum = 0;
		long endTime = System.currentTimeMillis();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(i=3;endTime-startTime<=2000;i++) {
			n = i;
			sum = 0;
			while(n!=0) {
				r = n%10;
				sum+=factorial(r);
				n=n/10;
			}
			if(sum==i) {
				System.out.println(i);
				arr.add(i);
			}	
			endTime = System.currentTimeMillis();
		}
		sum=0;
		for(i=0;i<arr.size();i++)
			sum+=arr.get(i);
			
		System.out.println("Total sum = "+sum);
	}
	
	public static long factorial(int a) {
		 int i;
		 int fact=1;
		 for(i=2;i<=a;i++)
		 	fact *= i;
		 return fact;
	}
}	
