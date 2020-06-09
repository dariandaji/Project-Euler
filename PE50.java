/*
The longest run is at least 21 long. So, the maximum number of elements we must
execute to has to be 1000000/21 = ~48000 
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE50 {
	public static void main(String args[])throws Exception {
		int i;
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		
		for(i=3;i<48000;i+=2) 
			if(isPrime(i)) 
				prime.add(i);
	
		long max = countChain(prime);
		System.out.println("The longest chain sum: "+max);
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: "+(endTime-startTime)+"ms");
	}
	
	public static long countChain(ArrayList<Integer> prime) {
		int i,j;
		int flag = 0;
		long sum = 0;
		int chain = 21; //minimum length is 21 from the question
		int max_chain = 21;
		long max_prime=0; 
		i=0;
		
		while(chain!=prime.size()) {
			for(i=0;i<prime.size()-chain;i++) {
				flag = 0;
				sum = 0;
				for(j=i;j<i+chain;j++) {
					sum+= prime.get(j);
					if(sum>1000000) {
						flag=1;						
						break;
					}
				}
//				System.out.println(sum+" "+chain);
				if(flag==0 && isPrime(sum)) {
					System.out.println(sum+" "+chain);
					max_chain = chain;
					max_prime = sum;
					chain++;
					break;
				}
			}
			chain++;
		}
		
		return max_prime;
		
		
	}
					
	public static boolean isPrime(long a) {
		int i;
		for(i=2;i<a;i++) 
			if(a%i==0)
				return false;
		return true;
	}
}
