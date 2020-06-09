//https://www.mathblog.dk/project-euler-31-combinations-english-currency-denominations/
//solved using dynamic programming

import java.io.*;
import java.util.*;
import java.math.*;
class PE31 {
	public static void main(String args[])throws IOException {
		int total = 200;
		int coins[] = {1,2,5,10,20,50,100,200};
		int ways[]=new int[total+1];
		ways[0]=1;
		int i,j;
		for(i=0;i<coins.length;i++) {
			for(j=coins[i];j<=total;j++) {
				ways[j] += ways[j - coins[i]];
			}
		}
		System.out.println("200p can be generated in "+ways[ways.length-1]+" ways.");
	}
}
