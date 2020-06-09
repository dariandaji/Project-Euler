/*
MARKED INCORRECT 
WILL WORK ON IT LATER

*/


import java.io.*;
import java.util.*;
import java.math.*;
class PE40_2 {
	public static void main(String args[])throws Exception {
 		int digits = 1;
 		int i;
 		float difference, residual;
 		float number = 1.0f;
 		ArrayList<Float> list = new ArrayList<Float>();
 		list.add(1.0f); //digit d1
 		/*for(i=1;i<10;i++) {
 			difference = (float)(Math.pow(10,i)-digits)/i;
 			number = number + difference;
 			digits = digits + difference * i;
 			list.add(number);
 			if(digits>1000000) break;
 			residual = (float)(Math.pow(10,i) - number);
 			number = number + residual;
 			digits = digits + difference * i;
 		}*/
 	/*	number = 1.0f;
 		digits = 1;
 		for(i=0;i<=6;i++) {	
 			difference = (float) Math.pow(10,i)-number;
 			digits = digits + difference * i;
 			number = number + difference;
 			if(digits%Math.pow(i)==0)
 				list.add(number);
 				
 		*/
 		
 		
 		
 		
 		
 		System.out.println("The numbers are: ");
 		for(i=0;i<list.size();i++)	
 			System.out.println(list.get(i));
 	
 		calculate_product(list);
	}
	
	public static void calculate_product(ArrayList<Float> list) {
		int i;
		String s;
		int product = 1;
		for(i=0;i<7;i++) {
			s = Float.toString(list.get(i));
			product *= (int)(s.charAt(0)-48);
		}
		System.out.println("The product is: "+product);
	}	
}
