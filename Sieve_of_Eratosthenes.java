//https://www.geeksforgeeks.org/sieve-of-eratosthenes/
import java.io.*;
import java.math.*;
import java.util.*;
class Sieve_of_Eratosthenes {
	public ArrayList<Integer> sieve(int n) {
		boolean prime[] = new boolean[n+1];
		int i;
		for(i=0;i<n;i++)
			prime[i] = true;
		
		int p;
		for(p=2;p*p<=n;p++) 
			if(prime[p] == true) 
				for(i=p*p;i<=n;i+=p) 
					prime[i] = false;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(i=2;i<=n;i++)
			if(prime[i])
				list.add(i);
				
		return list;
				
	}

	public static void main(String args[])throws Exception {
		int n = 100;
		System.out.println("List of primes -> ");
		Sieve_of_Eratosthenes s = new Sieve_of_Eratosthenes();
		s.sieve(n);
	}
}

