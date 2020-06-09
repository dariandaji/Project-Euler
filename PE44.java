/*
The formula to check whether a number is pentagonal is 
(1+(24n+1)^1/2)/6 must be an integer
https://radiusofcircle.blogspot.com/2016/06/problem-44-project-euler-solution-with-python.html
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE44 {
	public static void main(String args[])throws Exception {
		int i,j,flag=0;
		int a,b;
		ArrayList<Integer> differences = new ArrayList<Integer>();
		final long startTime = System.currentTimeMillis();

		for(i=1;flag==0;i++) {
			for(j=1;j<i;j++) {
				a = (i*(3*i-1))/2;
				b = (j*(3*j-1))/2;
//				System.out.println(a+" "+b);
				if(isPent(a+b) && isPent(a-b)) {
					System.out.println(a+" + "+b+" = "+(a+b));
					System.out.println(a+" - "+b+" = "+(a-b));
					flag=1;
					break;
				}
			}
			i++;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time = "+(endTime-startTime)+"ms");
	}
	
	public static boolean isPent(int x) {
		if((1+Math.pow((24*x+1),0.5))%6 == 0) 
			return true;
		return false;
	}
}	
