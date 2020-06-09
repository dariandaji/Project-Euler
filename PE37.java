//Inefficient solution
import java.io.*;
import java.util.*;
import java.math.*;
class PE37 {
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static void main(String args[])throws IOException {
		int i,j,flag;
		String s;
		
		for(i=2;i<1000000;i++) {
			flag = 0;
			for(j=2;j<i;j++) {
				if(i%j==0) {
					flag=1;
					break;
				}
			}
			if(flag==0) 
				primes.add(i);
		}
		/*System.out.println("List of primes: ");
		for(i=0;i<primes.size();i++) 
			System.out.println(primes.get(i));*/
		System.out.println("List of truncatable primes-> ");
		int sum=0;
		for(i=4;i<primes.size();i++) { //2,3,5,7 are not to be considered
			if(check_truncatable(primes.get(i))) {
				System.out.println(primes.get(i));
				sum+=primes.get(i);
			}
		}
		System.out.println("Sum of truncatable primes: "+sum);
	}
	
	public static boolean check_truncatable(int x) {
		//checking by truncating left to right
		int n = x;
		int len = Integer.toString(x).length()-1;
	
		while(n!=0 && len!=0) {
			n = n%((int)Math.pow(10,len));
			if(!check_prime(n))
				return false;
			 len--;
		}
		
		//now checking by truncating right to left
		n = x;
		len = Integer.toString(x).length()-1;
		int l=0;
		while(n!=0 && l!=len) {
			n = n/10;
			if(!check_prime(n))
				return false;
			l++;	
		}
		return true;
	}
				
	public static boolean check_prime(int n) {
		int i;
		for(i=0;i<primes.size();i++) 
			if(primes.get(i)==n)
				return true;
		return false;
	}	
}

