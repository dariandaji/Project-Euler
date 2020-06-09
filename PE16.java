import java.io.*;
import java.math.*;
class PE16 {
	public static void main(String args[])throws IOException {
		BigInteger a = new BigInteger("2");
		BigInteger n = a.pow(1000);
		
		String s = n.toString();
//		System.out.println(s);
		int sum=0;
		for(int i=0;i<s.length();i++) {
			int ch = (int)(s.charAt(i)-48);
			sum+=ch;
		}
		System.out.println("The sum of the digits is: " +sum);
	}
}
		
		
