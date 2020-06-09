import java.io.*;
import java.math.*;
import java.util.*;
class PE53 {
	public static void main(String args[])throws Exception {
		long startTime = System.currentTimeMillis();
		int n,r;
		BigInteger value;
		BigInteger million = new BigInteger("1000000");
		int count = 0;
		for(n=1;n<=100;n++) {
			for(r=0;r<=n;r++) {
				System.out.println(n+"C"+r);
				value = C(n,r);
				if(value.compareTo(million)>0) 
					count++;
			}
		}
		System.out.println("Total count = " +count);
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: "+(endTime-startTime)+"ms");
	}
	
	public static BigInteger C(int n, int r) {
		/*long num;
		long den;
		num = fact(n);
		den = fact(r) * fact(n-r);
		num = num/den;
		
		return num;*/
		BigInteger n1 = new BigInteger(Integer.toString(n));
		BigInteger r1 = new BigInteger(Integer.toString(r));
		
		BigInteger num = fact(n1);
		BigInteger den = fact(r1).multiply(fact(n1.subtract(r1)));
		
		BigInteger value = num.divide(den);
		return value;
	}
	
	public static BigInteger fact(BigInteger x) {
		if(x.compareTo(new BigInteger("0"))==0) return new BigInteger("1");
		int i;
		int x2 = Integer.parseInt(x.toString());
		BigInteger i2;
		BigInteger factorial = new BigInteger("1");
		for(i=2;i<=x2;i++) {
			i2  = new BigInteger(Integer.toString(i));
			factorial = factorial.multiply(i2);
		}
		
		return factorial;
	}
}
