import java.io.*;
import java.util.*;
import java.math.*;
class PE38 {
	public static void main(String args[])throws Exception {
		
		int n,i,x;
		String s = "";
		ArrayList<String> pans = new ArrayList<String>();
		//n is at most a 4-digit number, because a 5 digit number 
		//will yield a total length>9 upon concatenation
		for(n=1;n<10000;n++) {
			s = "";
			for(i=1;i<10;i++) {
				x = n*i;
				s += Integer.toString(x);
				if(s.length()==9) {
					if(checkPan(s)) {
						System.out.println(n+" -> "+s);
						pans.add(s);
					}
				}
			}
		}
		max_pans(pans);
	}
	
	public static boolean checkPan(String s) {
		int digits[] = new int[10];
		int i;
		for(i=0;i<s.length();i++) 
			digits[(int)(s.charAt(i)-48)]++;
			 	
		for(i=1;i<=9;i++)
			if(digits[i]!=1)
				return false;
		return true;
	}
	
	public static void max_pans(ArrayList<String> pans) {
		int i;
		long x, max_x=0;
		for(i=0;i<pans.size();i++) {
			x = Long.parseLong(pans.get(i));
			if(x>max_x)
				max_x = x;
		}
		System.out.println("The largest 9-digit pandigital number is: "+max_x);
	}
}
