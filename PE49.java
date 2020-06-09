import java.io.*;
import java.math.*;
import java.util.*;
class PE49 {
	static int count = 0;
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	public static void main(String args[])throws Exception {
		int i;
		for(i=1000;i<3334;i++) {	//4 digit number. if number is 3333, the last number would be 9999
			if(isPrime(i)) {
				if(checkPermutations(i)) {
				
					count++;
					if(count==2) System.exit(0);
				}
			}
		}
	}
	
	public static boolean isPrime(int a) {
		int i;
		for(i=2;i<a;i++)
			if(a%i==0)
				return false;
		return true;
	}
	
	public static boolean checkPermutations(int a) {
		String s = Integer.toString(a);
		int i,j,k,l;
		String s2 = "";
		int temp, temp2, diff;
		
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++) {
				for(k=0;k<4;k++) {
					for(l=0;l<4; l++) {
						if(j!=i && k!=j && k!=i && l!=i && l!=j && l!=k) {
							s2 = Character.toString(s.charAt(i))+Character.toString(s.charAt(j))+Character.toString(s.charAt(k))+Character.toString(s.charAt(l));
							temp = Integer.parseInt(s2);
							if(temp>a && isPrime(temp)) {
								diff = temp - a;
								temp2 = temp+diff;
								if(isPrime(temp2) && isPermutation(temp, temp2)) {
									System.out.println(a+"-"+temp+"-"+temp2);
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isPermutation(int a, int b) {
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		int i;
		if(s1.length()!=s2.length())
			return false;
			
		int digits1[] = new int[10];
		int digits2[] = new int[10];
		
		for(i=0;i<s1.length();i++) {
			digits1[s1.charAt(i)-48]++;
			digits2[s2.charAt(i)-48]++;
		}
		
		for(i=0;i<10;i++)
			if(digits1[i]!=digits2[i])
				return false;
						
		return true;
	}
}
