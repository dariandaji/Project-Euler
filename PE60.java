import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE60 {
	public static void main(String args[])throws Exception {
		Sieve_of_Eratosthenes s = new Sieve_of_Eratosthenes();
		ArrayList<Integer> primes = s.sieve(10000);
		/*for(int i=0;i<primes.size();i++)
			System.out.println(primes.get(i));*/
		long startTime = System.currentTimeMillis();
		int i,j,k,l,m;
		int values[] = new int[20];	//there are 5P2 combinations = 20
		for(i=1;i<primes.size();i++) { //i=0 means 2 which cannot concatenate to form a prime
			for(j=i+1;j<primes.size();j++) {
				values[0] = combine(primes.get(i), primes.get(j));
				values[1] = combine(primes.get(j), primes.get(i));				
				if(isPrime(values[0]) && isPrime(values[1])) {
System.out.println(primes.get(i)+" "+primes.get(j));

					for(k=j+1;k<primes.size();k++) {
					
					
						values[2] = combine(primes.get(i), primes.get(k));
						values[3] = combine(primes.get(k), primes.get(i));
						values[4] = combine(primes.get(j), primes.get(k));
						values[5] = combine(primes.get(k), primes.get(j));
						if(isPrime(values[2]) && isPrime(values[3]) && 
							isPrime(values[4]) && isPrime(values[5])) {
							
							System.out.println(primes.get(i)+" "+primes.get(j)+" " +primes.get(k));
							
							for(l=k+1;l<primes.size();l++) {
								values[6] = combine(primes.get(i), primes.get(l));
								values[7] = combine(primes.get(l), primes.get(i));
								values[8] = combine(primes.get(j), primes.get(l));
								values[9] = combine(primes.get(l), primes.get(j));
								values[10] = combine(primes.get(k), primes.get(l));
								values[11] = combine(primes.get(l), primes.get(k));
								if(isPrime(values[6]) && isPrime(values[7]) && 
									isPrime(values[8]) && isPrime(values[9]) &&
									isPrime(values[10]) && isPrime(values[11])) {
									
									System.out.println(primes.get(i)+" "+primes.get(j)+" "+primes.get(k)
									+" "+primes.get(l));
									
									for(m=l+1;m<primes.size();m++) {
										values[12] = combine(primes.get(i), primes.get(m));
										values[13] = combine(primes.get(m), primes.get(i));
										values[14] = combine(primes.get(j), primes.get(m));
										values[15] = combine(primes.get(m), primes.get(j));
										values[16] = combine(primes.get(k), primes.get(m));
										values[17] = combine(primes.get(m), primes.get(k));
										values[18] = combine(primes.get(l), primes.get(m));
										values[19] = combine(primes.get(m), primes.get(l));
										if(isPrime(values[12]) && isPrime(values[13]) && 
											isPrime(values[14]) && isPrime(values[15]) &&
											isPrime(values[16]) && isPrime(values[17]) &&
											isPrime(values[18]) && isPrime(values[19])) {
												System.out.println("The set of five primes is: " 
													+primes.get(i) +" "+ primes.get(j) + " "+ primes.get(k)+
													" "+primes.get(l)+" "+primes.get(m));
												System.out.println("Sum = "+(primes.get(i)+primes.get(j)
													+primes.get(k)+primes.get(l)+primes.get(m)));
												long endTime = System.currentTimeMillis();
												System.out.println("Total execution time: "+(endTime - startTime)
																	+"ms");
												System.exit(0);
										}
									}
								}
							}
						}
					}
				}
			}
		}	 								
	}
	/*
	public static boolean isPrime(int n) {
		int i;
		for(i=2;i<=Math.sqrt(n);i++) 
			if(n%i==0)
				return false;
		return true;
	}
	*/
	
	public static boolean isPrime(int n) {
		Miller_Rabin mr = new Miller_Rabin();
		if(mr.isPrime(n, 4)) 
			return true;
		return false;
	}
	
	public static int combine(int i, int j) {
		String s = Integer.toString(i) + Integer.toString(j);
		int comb = Integer.parseInt(s);
		return comb;
	}
}
