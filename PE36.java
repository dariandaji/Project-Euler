import java.io.*;
import java.util.*;
import java.math.*;
class PE36 {
	public static void main(String args[])throws IOException {
		int i,sum=0;
		String s1,s2;
		for(i=0;i<1000000;i++) {
			s1 = Integer.toString(i);
			if(isPalindrome(s1)) {
				s2 = Integer.toString(i,2);	//base has been set to 2 to convert to binary
				if(isPalindrome(s2)) {
					System.out.println(s1+" = "+s2+"(2)");
					sum+=i;
				}
			}
		}
		System.out.println("Total sum = "+sum);
	}
	
	public static boolean isPalindrome(String s) {
		int i=0;
		int j = s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j)) 
				return false;
			i++; j--;
		}
		return true;
	}			
}
