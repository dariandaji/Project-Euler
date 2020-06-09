import java.io.*;
import java.util.*;
class PE23 {
	public static void main(String args[]) throws IOException {
		int i,j;
		int sum=0;
		ArrayList<Integer> abundant =  new ArrayList<Integer>();
		for(i=1;i<=28123;i++) {
			sum=0;
			for(j=1;j<i;j++)
				if(i%j==0)
					sum+=j;
			if(sum>i)
				abundant.add(i);	
		}
/*		System.out.println("List of abundant numbers: ");
		for(i=0;i<abundant.size();i++)
			System.out.println(abundant.get(i));
	*/
		ArrayList<Integer> abundant_sums = new ArrayList<Integer>();
		int x,y;
		for(i=0;i<abundant.size();i++) {
			x = abundant.get(i);
			for(j=0;j<abundant.size();j++) {
				y = abundant.get(j);
				if(x+y<=28123) {
					y=x+y;
					abundant_sums.add(y);
				}
			}
		}
		/*System.out.println("List of summed abundant numbers: ");
		for(i=0;i<abundant.size();i++)
			System.out.println(abundant_sums.get(i));*/
		
/*		
		for(i=0;i<abundant_sums.size()-1;i++)
			if(abundant_sums.get(i)==abundant_sums.get(i+1)) {
				System.out.println(abundant_sums.get(i));
				i++;
			}*/
			
		Collections.sort(abundant_sums);	
	/*	for(i=0;i<abundant_sums.size();i++)
			System.out.println(abundant_sums.get(i));
*/
		long not_abundant_sums_sum = 0;
		i=1;
		j=0;
		x=0;
		System.out.println("List of non-abundant summed numbers: ");
		
		while(i<28124) {
			x = abundant_sums.get(j);
			while(i<x) {
				System.out.println(i);
				not_abundant_sums_sum+=i;
				i++;	
			}
			while(x==abundant_sums.get(j)) { 	//to prevent duplications. Hence, we sorted the list.	
				j++;
				if(j==abundant_sums.size())
					break;
			}
			if(j==abundant_sums.size())
				break;
			i++;
		}
		System.out.println("The sum of all non-abundant numbers is: "+not_abundant_sums_sum);
	}
}
		
		
