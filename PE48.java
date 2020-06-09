import java.io.*;
import java.math.*;
import java.util.*;
class PE48 {
	public static void main(String args[])throws Exception {
		String digits = "";
		BigInteger sum = new BigInteger("0");
		int i;
		BigInteger a;
		
		for(i=1;i<=1000;i++) {
			a = new BigInteger(Integer.toString(i));
			sum = sum.add(a.pow(i));
		}
		digits = sum.toString(10);
		digits = digits.substring(digits.length()-10,digits.length());
		System.out.println("The last 10 digits are: "+digits);
	}
}
