import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE55 {
	public static void main(String args[])throws Exception {	
		int i,j;
		BigInteger n;
		BigInteger rev_n;
		BigInteger sum;
		int cnt = 0, flag=0;
		for(i=1;i<10000;i++) {
			n = new BigInteger(Integer.toString(i));
			j=0;
			flag = 0;
			while(j<50) {
				rev_n = reverse(n);
				sum = n.add(rev_n);
				if(check_palin(sum)) {
					flag = 1;
					break;
				}
				n = sum;
				j++;
			}
			if(flag==0) {
				cnt++;
			//	System.out.println(n);
			}
		}
		System.out.println("Total number of Lychrel numbers is: "+cnt);
	}
	
	public static BigInteger reverse (BigInteger n) {
		StringBuffer str = new StringBuffer(n.toString());
		str.reverse();
		n = new BigInteger(str.toString());
		return n;
	}
	
	public static boolean check_palin(BigInteger sum) {
		String s1 = sum.toString();
		StringBuffer s = new StringBuffer(s1);
		String s2 = s.reverse().toString();
		if(s1.compareTo(s2)==0)
			return true;
		return false;
	}
}
