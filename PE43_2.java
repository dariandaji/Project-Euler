import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
class PE43_2 {
	static long SUM = 0;
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String args[])throws IOException {
		String s = "";
		int prime[] = {2,3,5,7,11,13,17};
		int i,j,k;
		ArrayList<String> first = new ArrayList<String>();
		for(i=10;i<1000;i++) {
			if(i%2==0) {
				if(i<100) 
					first.add("0"+Integer.toString(i));
				else first.add(Integer.toString(i));
			}
		}
		
		k = 1;
		long check;
		String digits[] = {"0","1","2","3","4","5","6","7","8","9"};
		String temp = "";
		String sub = "";
		
		//for(i=0;i<first.size();i++) { //skip the 2 part because we have done it in the previous step	
		i=0;
		while(i<first.size()) {
			s = first.get(i);
			temp = s;
			k=1;
			for(j=0;j<digits.length;j++) {
				temp += digits[j];	//add 1 digit at a time
				sub = temp.substring(temp.length()-3, temp.length()); //extract last 3 characters
				check = Long.parseLong(sub);
				
				if(check%prime[k]==0 && !inList(temp)) {	//number must not be already present in the list
					if(checkPan(temp)) { 
						s += digits[j];
						//System.out.println(s);
						list.add(s);	
						k++;
						j=-1;
						
						if(s.length()==9) {
							i++;	
							break;
						}
						continue;
					}
				}
				temp = temp.substring(0,temp.length()-1);
				if(j==9) {
					if(temp.length()==3) {	//if length is 3 we move to the next in the "first" list
						i++;
						break;
					}	
					temp = temp.substring(0,temp.length()-1); //just remove the last digit we added and continue 
															//looping. This is why we are checking to see if a 
															//number was already visited using the "inList()" 
															//function
				}
			}
		}
		//System.out.println(list);	
		System.out.println("Total sum = "+SUM);
	}
	
	public static boolean checkPan(String s) {
		int digit[] = new int[10];
		int i;
		
		for(i=0;i<s.length();i++) {
			digit[s.charAt(i)-48]++;
			if(digit[s.charAt(i)-48]>1)
				return false;
		}
		
		long value=0;
		if(s.length()==9) { //find the one digit that is missing
			for(i=0;i<10;i++) {
				if(digit[i]==0) {
					s = Integer.toString(i)+s;
					value = Long.parseLong(s);
					SUM+=value;
					System.out.println(s);
				}
			}
		}
								
		return true;
	}
	
	public static boolean inList(String s) {
		int len = s.length();
		int i;
		for(i=0;i<list.size();i++) 
			if((list.get(i).length()>=len) && (list.get(i).substring(0,len)).equals(s))
				return true;
				
		return false;
	}
	
}
