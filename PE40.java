//long, inefficient solution
import java.io.*;
import java.util.*;
import java.math.*;
class PE40 {
	public static void main(String args[])throws Exception {
		int i;
		String str = "", str2 = "";
		ArrayList<Integer> digit = new ArrayList<Integer>();
		int cnt = 0;
		
		for(i=1;;i++) {
			str2 = Integer.toString(i);
			str += str2;
			cnt += str2.length();
			System.out.println(cnt);
			if(cnt>1000000) break;
			}
		digit.add((int)str.charAt(0)-48);
		digit.add((int)str.charAt(9)-48);	
		digit.add((int)str.charAt(99)-48);	
		digit.add((int)str.charAt(999)-48);	
		digit.add((int)str.charAt(9999)-48);
		digit.add((int)str.charAt(99999)-48);
		digit.add((int)str.charAt(999999)-48);
		
		int product = 1;
		for(i=0;i<digit.size();i++) 
			product *= digit.get(i);
			
		System.out.println("The product is: "+product);
	}
}
