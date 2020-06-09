import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
class PE57 {
	public static void main(String args[])throws Exception {
		BigInteger num = new BigInteger("3");	//after 1st iteration
		BigInteger den = new BigInteger("2");
		int i, cnt=0;
		String s = "";
		String arr[] = new String[2];
		for(i=1;i<1000;i++) {
			s = next_iteration(num,den);
			arr = s.split("/");
			System.out.println(arr[0]+"/"+arr[1]);
			num = new BigInteger(arr[0]);
			den = new BigInteger(arr[1]);
			if(arr[0].length()>arr[1].length()) 
				cnt++;
		}
		System.out.println("Number of times numerator had more digits than denominator: "+cnt);
	}
		
	
	public static String next_iteration(BigInteger num, BigInteger den) {
		BigInteger num2 = den.add(num);
		num = den;
		den = num2;
		
		num2 = den.add(num);
		num = num2;
		String s = num.toString()+"/"+den.toString();
		return s;
	}
}
		
