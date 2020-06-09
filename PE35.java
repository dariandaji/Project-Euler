/*
Code takes extremely long to run
*/
import java.io.*;
import java.util.*;
import java.math.*;
class PE35 {
	public static void main(String args[])throws IOException {
		final long startTime = System.currentTimeMillis();
		int i;
		String s;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int cnt = 0;
		primes.add(2);
		for(i=3;i<1000000;i+=2) 
			if(isPrime(i)) {
				System.out.println(i);
				primes.add(i);
		}
		
		for(i=0;i<primes.size();i++) {	
			if(isCircularPrime(primes.get(i))) {
				System.out.println(primes.get(i));
				cnt++;
			}
		}
		System.out.println("Total number of cyclic primes under one million: " +cnt);		
		long endTime = System.currentTimeMillis();
		System.out.println("Total run-time = " +(endTime-startTime));	
	}

	public static boolean isPrime(int a) {
		int i;
		for(i=2;i<a;i++)
			if(a%i==0)
				return false;
		return true;
	}

	public static boolean isCircularPrime(int x) {
		int i;
		String s = Integer.toString(x);
		for(i=0;i<s.length();i++) 
			if((s.charAt(i)=='0'||s.charAt(i)=='2'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='8') && (s.length()>1))	//any of these digits in the units place makes the number not prime
				return false;
			
		int temp;
		for(i=0;i<s.length()-1;i++) {	//length-1 because we already know the first number is a string
			s = s.substring(1)+s.substring(0,1); //moving first character to the last place
			temp = Integer.parseInt(s);
			if(!isPrime(temp)) 
				return false;
		}
		return true;
	}
}
