import java.io.*;
import java.math.*;

class PE20 {
	public static void main(String args[])throws IOException {
		BigInteger a = new BigInteger("100");
		BigInteger fact = new BigInteger("1");
		String n;
		
		for(int i=2;i<=100;i++) {
			n = Integer.toString(i);
			fact = fact.multiply(new BigInteger(n));
		}
		System.out.println("100! = "+fact);

		String no = fact.toString(10);
		int ch,sum=0;
		for(int i=0;i<no.length();i++) {
			ch = (int)(no.charAt(i)-48);
			sum+=ch;
		}
		System.out.println("The sum of the digits = " +sum);
	}
}
