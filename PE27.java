import java.io.*;
import java.util.*;
import java.math.*;
class PE27 {
	public static void main(String args[])throws IOException {
		int i,j;
		int n,a,b;
		int prime_cnt=0, max_primes=0, max_a=0, max_b=0;
		int calc;
		for(a=-999;a<1000;a++) {
			for(b=-1000;b<=1000;b++) {
				prime_cnt=0;
				for(n=0;;n++) {
					calc = Math.abs(n*n + a*n + b);
					if(isprime(calc)) 
						prime_cnt++;			
					else break;
				}
				if(prime_cnt>max_primes) {
					max_primes = prime_cnt;
					max_a = a;
					max_b = b;
				}
			}
		}
		System.out.println("The maximum number of consecutive primes are: "+max_primes+" for a= "+max_a+" and b= "+max_b);
		System.out.println("The product of a and b = "+(max_a*max_b));
	}
		
	public static boolean isprime(int a) {
		int i;
		for(i=2;i<a;i++)
			if(a%i==0) return false;
		return true;
	}	
}		
