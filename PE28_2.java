/*
TO solve this problem note the diagonal and see that starting from 1, the number 
increases by adding 8 to each step, in any direction of the diagonals,
i.e. 1,3,13,31,57 which has a difference of 2,10,18,26 between each other
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE28_2 {
	public static void main(String args[])throws IOException {

		//calculate starting from 1 and moving in the top left direction
		int first = 1;
		int next[] = new int[4];
		int sum[] = new int[4];
		int difference[] = new int[4];
		
		next[0]=3;
		next[1]=7;
		next[2]=9;
		next[3]=5;
		
		sum[0]=0;sum[1]=0;sum[2]=0;sum[3]=0;
		
		difference[0]=next[0]-first;
		difference[1]=next[1]-first;
		difference[2]=next[2]-first;
		difference[3]=next[3]-first;
		
		sum[0] = first+next[0];
		sum[1] = first+next[1];
		sum[2] = first+next[2];
		sum[3] = first+next[3];
		
		int i, total_sum=0;
		for(i=1;i<500;i++) {
			difference[0]+=8;
			difference[1]+=8;
			difference[2]+=8;
			difference[3]+=8;
			
			next[0]+=difference[0];
			next[1]+=difference[1];
			next[2]+=difference[2];
			next[3]+=difference[3];
			
			sum[0]+=next[0];
			sum[1]+=next[1];
			sum[2]+=next[2];
			sum[3]+=next[3];
	
		}
		total_sum+=sum[0]+sum[1]+sum[2]+sum[3]-3;	//the 1 gets added 4 times hence -3
		System.out.println("The total sum of both diagonals is: "+total_sum);
	}
}	
