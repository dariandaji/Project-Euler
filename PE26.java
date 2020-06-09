//https://www.xarg.org/puzzle/project-euler/problem-26/
/*
Full reptend primes are known to have recurring cycles of d-1;
It would have been simple to simply pick the largest reptend prime for the solution,
but the code checks to ensure that there is a repeating cycle in every number and selects
the solution only then from the full reptend set. 
*/
import java.io.*;
import java.math.*;
import java.util.*;
class PE26 {
	public static void main(String args[])throws IOException {
		BigDecimal num = new BigDecimal("1");
		BigDecimal den = new BigDecimal("0");
		//the next line is an example of divide function
		//BigDecimal res = num.divide(den,50, RoundingMode.CEILING);
		int i;
		int cycle_len=0;
		int max_cycle_len=0;
		int max_cycle_den=1;
		BigDecimal res = new BigDecimal("1");
		String s="";
		int p,q;
		boolean check;
		String sub = "";
		
		for(i=2;i<1000;i++) {
			den = new BigDecimal(Integer.toString(i));
			res = num.divide(den, 2000, RoundingMode.CEILING);
			s = res.toString();
			s = s.substring(2,s.length()-1); //clipping the decimal notation and the last character 
		//System.out.println(s);
							
			check = divide(num,den);	//to see if it's a recurring decimal
			if(check) {
				sub = s.substring(0,den.subtract(new BigDecimal("1")).intValue()); //-2 because length-1 and that is already den-1 as stated in the solution for reptend primes
				//System.out.println(sub);
				if(sub.equals(s.substring(sub.length(),sub.length()+sub.length())) && check_full_reptend(i) ) {
				//System.out.println(s.substring(sub.length(),sub.length()+sub.length()));
					cycle_len = sub.length();
					if(cycle_len > max_cycle_len) {
						max_cycle_len = cycle_len;
						max_cycle_den = i;
					}
				}
			}
			else continue;					
		}
		System.out.println("The longest recurring decimal occurs for the denominator: "+max_cycle_den);
	}
	
	public static boolean divide(BigDecimal num, BigDecimal den) {	//checks if a number has a recurring point
																	//not worth the overhead
		BigDecimal res;
		try {
			num.divide(den);
			return false;
		} catch(ArithmeticException ae) {
			return true;
		}
	}
	
	public static boolean check_full_reptend(int i) {
		int reptend[] = {7, 17, 19, 23, 29, 47, 59, 61, 97, 109, 113, 131, 149, 167, 179, 181, 193, 223, 229, 233, 257, 263, 269, 313, 337, 367, 379, 383, 389, 419, 433, 461, 487, 491, 499, 503, 509, 541, 571, 577, 593, 619, 647, 659, 701, 709, 727, 743, 811, 821, 823, 857, 863, 887, 937, 941, 953, 971, 977, 983};
		//derived from the full reptend primes list on https://oeis.org/A001913
		for(int k=0;k<reptend.length;k++)
			if(reptend[k]==i)
				return true;
		return false;
	}	 
}
