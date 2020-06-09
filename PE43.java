import java.io.*;
import java.util.*;
import java.math.*;
class PE43 {
	static long sum=0;
	static ArrayList<String> d234 = new ArrayList<String>();
	static ArrayList<String> d345 = new ArrayList<String>();
	static ArrayList<String> d456 = new ArrayList<String>();
	static ArrayList<String> d567 = new ArrayList<String>();
	static ArrayList<String> d678 = new ArrayList<String>();
	static ArrayList<String> d789 = new ArrayList<String>();
	static ArrayList<String> d8910 = new ArrayList<String>();
	public static void main(String args[])throws IOException {		
	
		
		String temp;
		int i;
		for(i=10;i<1000;i++) {
			temp = Integer.toString(i);
			if(temp.length()<3) 
				temp = "0"+temp; //appending 0 to 2-digit numbers, 1-digit numbers are implicitly not pandigital 
				
			if(i%2==0) d234.add(temp);
			if(i%3==0) d345.add(temp);
			if(i%5==0) d456.add(temp);
			if(i%7==0) d567.add(temp);
			if(i%11==0) d678.add(temp);
			if(i%13==0) d789.add(temp);
			if(i%17==0) d8910.add(temp);
		}
		
		int size;
		long sum = 0;
		String s = "";
		for(i=0;i<d234.size();i++) {
			s = "";
			s = d234.get(i);
			join1(s, d345);
		}
		System.out.println("The sum of all pandigit numbers is: "+sum);
	}
	 
	public static void join1(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				join2(s,d456);
				if(!(arr.get(i+1).substring(0,2)).equals(sub1)) break;
			}
	}
	
	public static void join2(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				join2(s,d567);
			}
	}
	public static void join3(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				join2(s,d678);
			}
	}
	public static void join4(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				join2(s,d789);
			}
	}
	public static void join5(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				join2(s,d8910);
			}
	}
	public static void join6(String s, ArrayList<String> arr) {
		String sub1 = s.substring(s.length()-2,s.length());
		int i;
		for(i=0;i<arr.size();i++)
			if((arr.get(i).substring(0,2)).equals(sub1)) {
				s += arr.get(i);
				isPan(s);
			}			
	}
	
	public static void isPan(String s) {
		int digit[] = new int[10];
		int i,store=0,flag=0;
		for(i=0;i<s.length();i++)
			digit[s.charAt(i)-48]++;
				
		int cnt=0;		
		for(i=0;i<=9;i++) {
			if(digit[i]==0) {
				cnt++;
				store = i;
			} else if(digit[i]!=1) {
				flag = 1;	
				break;
			}
		}
		if(cnt==1 && flag==0) {	//only the first digit is missing
			s = Integer.toString(store)+s;
			System.out.println(s);
			sum+=Long.parseLong(s);
		}
	}
}
