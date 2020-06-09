/*
Test for Pentagonal number = https://en.wikipedia.org/wiki/Pentagonal_number
Test for Hexagonal number = https://en.wikipedia.org/wiki/Hexagonal_number
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE45 {
	public static void main(String args[])throws Exception {
		long n;
		long a;
		final long startTime = System.currentTimeMillis();
		for(n=286;;n++) {	//find the number after 285th term as per the question
			a = (n*(n+1))/2;
			System.out.println(a);
			if(isPent(a) && isHex(a)) {
				System.out.println("Triangle number that is also pentagonal and hexagonal: "+a);
				break;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " +(endTime - startTime)+"ms");
	}
	
	public static boolean isPent(long a) {
		if((Math.pow((24*a+1),0.5)+1)%6 == 0)
			return true;
		return false;
	}
	
	public static boolean isHex(long a) {
		if((Math.pow((8*a+1),0.5)+1)%4 == 0)
			return true;
		return false;
	}
}
