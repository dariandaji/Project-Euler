import java.io.*;
import java.util.*;
import java.math.*;
class PE33 {
	public static void main(String args[])throws IOException {
		int num=1,den=1;
		double frac;
		String s,s1,s2;
		int num1=1,den1=1;
		double frac1;
		
		ArrayList<Integer> numerators = new ArrayList<Integer>();
		ArrayList<Integer> denominators = new ArrayList<Integer>();
		
		for(num=10;num<100;num++) {
			for(den=num+1;den<100;den++) {
				frac = (double)num/den;
				//System.out.println(frac);
				
				s1 = Integer.toString(num);
				s2 = Integer.toString(den);
				s = s1+"/"+s2;
				if(s1.charAt(s1.length()-1)==s2.charAt(0)) {
					num1 = (int)(s1.charAt(0)-48);
					den1 = (int)(s2.charAt(s2.length()-1)-48);
					frac1 = (double)num1/den1;
					if(frac1==frac) {
						System.out.println(s1+"/"+s2+" = "+num1+"/"+den1);
						numerators.add(num1);
						denominators.add(den1);
					}
				}
			}
		}
	/*	int product=1;
		for(int i=0;i<numerators.size();i++) {
			if(denominators.get(i)%numerators.get(i)==0)	//because den>num here always 
				denominators.set(i, denominators.get(i)/numerators.get(i));
			product *= denominators.get(i);
		}*/
		int product1=1, product2=1;
		for(int i=0;i<numerators.size();i++) {
			product1 *= numerators.get(i);
			product2 *= denominators.get(i);
		}
		System.out.println("Product1 = "+product1+" Product2 = "+product2);
		for(int i=2;i<=product1;i++) {
			if(product1%i==0 && product2%i==0) {
				product1/=i;
				product2/=i;
				i--; //for example, where a number can be reduced 3 times by 2
			}
		}		
		System.out.println("The product of denominators is: "+product2);
	}
}
