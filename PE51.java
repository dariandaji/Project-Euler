/*
we perform bit masking here. eg.
If we have a string of length 5, we take 0 as the initial value of the mask. 
The mask = 00000. Now we have 2 for loops,
The first controls the mask value for the string and the second controls the digit to be replaced.
So, if the number is 56003, we start with 1 i.e. 00001(base 2) and change the last value to the digit determined
by the inner for loop. Like 56000, 56001, ..., 56009, at each stage checking for primes and if number = 8 break.
Then the outer loop becomes 2 = 00010 and the second digit is changed.
This will go on till the loop 11111 (or earlier), or if the prime count reaches 8.
*/

import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class PE51 {
	public static void main(String args[])throws Exception {
		int i,j, len, len2, count=0;
		String bin = "";
		long startTime = System.currentTimeMillis();
		
		for(i=56003;;i++) {
			len = Integer.toString(i).length();
			for(j=0;j<Math.pow(2,len);j++) {
				bin = Integer.toString(j,2);	//convert to binary
				bin = String.format("%"+len+"s", bin).replace(' ','0');
				//System.out.println(i+" "+bin);
				if(isPrime(i)) count = check(i,bin);
				if(count == 8) {
					System.out.println("The smallest prime is the first member in the above family of 8.");			
					long endTime = System.currentTimeMillis();
					System.out.println("Total execution time: "+(endTime-startTime)+"ms");
					System.exit(0);
				}
			}
		}
	}
	
	public static int check(int num, String bin) {
		int i;
		String str = Integer.toString(num);
		StringBuilder s = new StringBuilder(str);
		int digit;
		int count = 0;
		
		for(digit=1;digit<10;digit++) {
			i=0;
			while(i<bin.length()) {
				if(bin.charAt(i)=='1') 
					s.setCharAt(i, (char)(digit+48));
				i++;
			}
//			System.out.println(s);
			if(Integer.parseInt(s.toString())!=num && isPrime(Integer.parseInt(s.toString()))) {
				count++;
				System.out.println(s+" "+count);
				continue;
			}
		}
		return count;
	}
	
	public static boolean isPrime(int x) {
		int i;
		for(i=2;i<Math.sqrt(x);i++) 
			if(x%i==0)
				return false;
		return true;
	}	
}
