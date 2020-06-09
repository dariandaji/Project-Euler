import java.io.*;
import java.util.*;
import java.math.*;
class PE39 {
	public static void main(String args[])throws Exception {
		int p,a,b;
		float c;
		ArrayList<Integer> pyts = new  ArrayList<Integer>();
		//first we find all the solutions till 120, then multiply only those with 10 as these are the basic pythogorean triplets
		for(p=12;p<=1200;p++) {
			for(a=3;a<400;a++) {
				for(b=4;b<400;b++) {
					c = (float)Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
					if((c==(int)c) && (a+b+c==p) && (a+b>c)) { //check if c is an integer
						System.out.println(a+"+"+b+"+"+(int)c+"="+p);
						pyts.add(p);
					}
				}
			}
		}
		max_solution(pyts);
	}
	
	public static void max_solution(ArrayList<Integer> pyts) {
		int max_sol = 0;
		int max_p = 0;
		int i,temp,temp_sol;

		for(i=0;i<pyts.size();i++) {
			temp = pyts.get(i);
			temp_sol = 0;
			//adds all the solutions for a particular value as list is sorted
			while(i<pyts.size() && pyts.get(i)==temp) {
				temp_sol++;
				i++;
			}
			
			if(temp_sol>max_sol) {
				max_sol = temp_sol;
				max_p = temp;
			}
			i--; //-1 because the loop restarts with i++				
		}
		System.out.println("The maximum solutions are "+max_sol+" for the value of p = "+max_p);
	}		
}
