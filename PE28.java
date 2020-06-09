/*
TO solve this problem note the diagonal and see that starting from 1, the number 
increases by adding 8 to each step, in any direction of the diagonals,
i.e. 1,3,13,31,57 which has a difference of 2,10,18,26 between each other
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE28 {
	public static void main(String args[])throws IOException {
		//calculate starting from 1 and moving in the bottom right direction
		int first=1;
		int next = 3;
		int sum=0, total_sum=0;
		int i;
		int difference=next-first;
		sum = first+next;
		for(i=1;i<500;i++) {
			difference+=8;
//			System.out.print(difference);
			
			next+=difference;
	//		System.out.print(" " +next); 
			sum+=next;
		//	System.out.println(" "+sum);
		}
		
		total_sum+=sum;
		
		//calculate starting from 1 and moving in the top left direction
		first=1;
		next = 7;
		sum=0;
		difference=next-first;
		sum = first+next;
		for(i=1;i<500;i++) {
			difference+=8;
			//System.out.print(difference);
			
			next+=difference;
			//System.out.print(" " +next); 
			sum+=next;
			//System.out.println(" "+sum);
		}
		
		total_sum+=sum-1;	//the 1 was already calculated in the previous step
		
		//calculate starting from 1 and moving in the top right direction
		first=1;
		next = 9;
		sum=0;
		difference=next-first;
		sum = first+next;
		for(i=1;i<500;i++) {
			difference+=8;
			//System.out.print(difference);
			
			next+=difference;
			//System.out.print(" " +next); 
			sum+=next;
			//System.out.println(" "+sum);
		}
		
		total_sum+=sum-1;
		
		//calculate starting from 1 and moving in the bottom left direction
		first=1;
		next = 5;
		sum=0;
		difference=next-first;
		sum = first+next;
		for(i=1;i<500;i++) {
			difference+=8;
			//System.out.print(difference);
			
			next+=difference;
			//System.out.print(" " +next); 
			sum+=next;
			//System.out.println(" "+sum);
		}
		
		total_sum+=sum-1;
		System.out.println("The total sum of both diagonals is: "+total_sum);
	}
}	
