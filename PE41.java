/*
https://www.mathblog.dk/project-euler-41-pandigital-prime/
1+2+3+4+5+6+7+8+9 = 45
1+2+3+4+5+6+7+8 = 36 , both divisible by 3 and hence not prime
*/
import java.io.*;
import java.util.*;
import java.math.*;
class PE41 { 
	public static void main(String args[])throws IOException {
		int i;
		String digits[] = {"7","6","5","4","3","2","1"};	
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0;
		String s;
		int x;		
		/*for(a=0;a<7;a++) {
			for(b=0;b<7 && b!=a;b++) {
				for(c=0;c<7 && c!=b && c!=a;c++) {
					for(d=0;d<7 && d!=c && d!=b && d!=a;d++) {
						for(e=0;e<7 && e!=d && e!=c && e!=b && e!=a;e++) {
							for(f=0;f<7 && f!=e && f!=d && f!=c && f!=b && f!=a;f++) {
								for(g=0;g<7 && g!=f && g!=e && g!=d && g!=c && g!=b && g!=a;g++) {
									s = digits[a]+digits[b]+digits[c]+digits[d]+digits[e]+digits[f]+digits[g];
									System.out.println("g="+digits[g]);
									if(isPrime(s)) {
										System.out.println("The largest pandigital prime is: "+s);
										//System.exit(0);
									}
								}
							}
						}
					}
				}
			}
		}*/
		s = "";
		for(a=0;a<7;a++) {
			for(b=0;b<7;b++) {
				for(c=0;c<7;c++) {
					for(d=0;d<7;d++) {
						for(e=0;e<7;e++) {
							for(f=0;f<7;f++) {
								for(g=0;g<7;g++) {
									s = digits[a]+digits[b]+digits[c]+digits[d]+digits[e]+digits[f]+digits[g];
									if(isPan(s)) {
										System.out.println(s);
										if(isPrime(s)) {
											System.out.println("The largest pandigital prime is: "+s);
											System.exit(0);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean isPan(String s) {
		int check[] = new int[8];
		int i;
		for(i=0;i<s.length();i++) 
			check[s.charAt(i)-48]++;
		for(i=1;i<8;i++)
			if(check[i]!=1) return false;
		
		return true;
	}	
	
	public static boolean isPrime(String s) {
		long n = Long.parseLong(s);
		if(n%2==0) return false;
		int i;
		for(i=3;i<=(n/2);i+=2)
			if(n%i==0) return false;
		
		return true;
	}
}
			
