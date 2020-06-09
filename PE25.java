import java.io.*;
import java.util.*;
import java.math.*;
class PE25 {
	public static void main(String args[])throws IOException {
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		BigInteger f3 = new BigInteger("0");
		int cnt=2;	//starting from 2 because first 2 terms are already added
		while((f3.toString(10)).length()!=1000) {
			f3 = f1.add(f2);
			f1 = f2;
			f2 = f3;
			cnt++;
		}
		System.out.println("The index of the first 1000-digit Fibonacci number is: "+ cnt);
	}
}
