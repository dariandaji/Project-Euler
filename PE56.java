import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class PE56 {
	public static void main(String args[])throws Exception {
		int a, b;
		long sum = 0;
		long max_sum=0;
		int max_a=0, max_b=0;
		BigInteger a1;
		BigInteger prod;
		
		for(a=1;a<100;a++) {
			a1 = new BigInteger(Integer.toString(a));
			prod = new BigInteger("1");
			for(b=1;b<100;b++) {
				prod = prod.multiply(a1);
				sum = digits_add(prod);
//				System.out.println(a+"^"+b+" = "+sum);
				if(sum > max_sum) {
					max_sum = sum;
					max_a = a;
					max_b = b;
				}
			}
		}
		
		System.out.println("Maximum sum of digits: "+max_sum+ " for a="+max_a+" and b="+max_b);
	}
	
	public static long digits_add(BigInteger x) {
		String s = x.toString();
		int i;
		long sum=0;
		for(i=0;i<s.length();i++) 
			sum += (int)(s.charAt(i)-48);
		return sum;
	}
}
