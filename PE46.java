import java.io.*;
import java.util.*;
import java.math.*;
class PE46 {
	public static void main(String args[])throws IOException {
		int i,j;
		ArrayList<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		int flag;
		float calc = 0.0f;
		for(i=3;;i+=2) {	//has to be odd. We have already added 2 to primes list
			if(!isComposite(i)) {
				prime.add(i);
			} else {
				j=0;
				flag=1;
				while(j<prime.size() && prime.get(j)<i) {
					calc = i-prime.get(j);
					calc = (float)(calc/2);
					calc = (float)(Math.pow(calc,0.5));
					if(calc==(int)calc) {
						flag=0;
						break;
					}
					j++;
				}
				if(flag==1) {
					System.out.println("The number is: "+i); //could not find any identity for this number
					break;
				}
			}
		}
	}
	
	public static boolean isComposite(int x) {
		int i;
		for(i=2;i<x;i++)
			if(x%i==0) 
				return true;
		return false;
	}
}
