import java.io.*;
import java.math.*;
import java.util.*;
class PE29 {
	static ArrayList<BigInteger> values = new ArrayList<BigInteger>();
	public static void main(String args[])throws IOException {
		int a,b;
		BigInteger a1,b1;
		
		for(a=2;a<=100;a++) {
			for(b=2;b<=100;b++) {
				a1 = new BigInteger(Integer.toString(a));
				a1 = a1.pow(b);
				if(check(a1))
					values.add(a1);
			}
		}
		System.out.println("The number of distinct terms are: "+values.size());
	}
	
	public static boolean check(BigInteger a) {
		int i;
		for(i=0;i<values.size();i++) 
			if(a.equals(values.get(i)))
				return false;
		return true;
	}
}
					
