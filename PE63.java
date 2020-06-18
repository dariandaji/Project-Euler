import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE63 {
	public static void main(String args[])throws Exception {
		int i,j,cnt=0;
		String pow = "";
		for(i=1;i<10;i++) {
			for(j=1;;j++) {
				pow = power(i,j);
				if(pow.length()==j) {
					System.out.println(i+"^"+j+" = "+pow);
					cnt++;
				}
				if(pow.length()<j)
					break;
			}
		}
		System.out.println("Total number: "+cnt);
	}
	
	public static String power(int i, int j) {
		BigInteger prod = new BigInteger(Integer.toString(i));
		prod = prod.pow(j);
		return prod.toString();  
	}
}
