import java.io.*;
import java.math.*;
import java.util.*;
class PE32 {
	static ArrayList<Integer> products = new ArrayList<Integer>();
	public static void main(String args[])throws IOException {
		int i,j,p=1;
		
		String s,s1,s2;
		//4 digit no. * 1 digit no. = 4 digit no.
		//Therefore, total 9 digits. Hence, the for conditions
		for(i=1;i<100;i++) {
			for(j=1;j<10000;j++) {
				p = i*j;
				s = Integer.toString(p);
				s1 = Integer.toString(i);
				s2 = Integer.toString(j);
			
				s = s+s1+s2;
				if(s.length()==9) {
					if(check(s)) {
						if(!duplicates(p)) {
							System.out.println(p);
							products.add(p);
						}
					}
				} else continue;
			}
		}
		int sum=0;
		for(i=0;i<products.size();i++)
			sum += products.get(i);
		System.out.println("The sum of pandigital products is: "+sum);
	}
	
	public static boolean check(String s) {
		int arr[] =new int[10];
		int i;
		int ch;
		for(i=0;i<s.length();i++) {
			ch = (int)(s.charAt(i)-48);
			arr[ch]++;
		}
		for(i=1;i<10;i++)
			if(arr[i]!=1)
				return false;
		return true;
	}
	
	public static boolean duplicates(int p) {
		int i;
		for(i=0;i<products.size();i++) 
			if(p==products.get(i))
				return true;
		return false;
	}
}


