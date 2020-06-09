import java.io.*;
import java.util.*;
import java.math.*;
class PE52 {
	public static void main(String args[])throws Exception {
		int i,j;
		for(i=1000;;i++) {
			for(j=2;j<=6;j++) {
				if(check(i,i*j)) {
					if(j==6) {
						System.out.println("The smallest integer is: "+i);
						System.exit(0);
					}
				} else break;
			}
		}
	}
	
	public static boolean check(int i, int j) {
		String s1 = Integer.toString(i);
		String s2 = Integer.toString(j);
		
		if(s1.length()!=s2.length()) return false;
		
		int digits1[] = new int[10];
		int digits2[] = new int[10];
		
		int k;
		for(k=0;k<s1.length();k++) {
			digits1[s1.charAt(k)-48]++;
			digits2[s2.charAt(k)-48]++;
		}
		
		for(k=0;k<10;k++) 
			if(digits1[k]!=digits2[k])
				return false;
		return true;
	}
}
