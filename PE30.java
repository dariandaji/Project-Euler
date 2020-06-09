import java.io.*;
import java.util.*;
import java.math.*;
class PE30 {
	public static void main(String args[])throws IOException {
		int i,n,r,sum;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		final long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		
		//The code runs for 2 seconds flat. An alternative would be to calculate the upper bound.
		//For this code, for a 6 digit number, 999999, we get total sum of 354294. 
		//This can be set as the upper bound. Larger numbers with 7 digits also yield only a 6 digit sum
		//Hence the upper bound can be safely set 354300 or so. 
		//for(i=2;i<354300;i++) {
		for(i=2;(endTime-startTime)<=2000;i++) {
			n=i;
			sum=0;
			while(n!=0) {
				r = n%10;
				r = (int)Math.pow(r,5);
				sum+=r;
				n=n/10;
			}
			if(sum==i)
				list.add(i);
			endTime = System.currentTimeMillis();
		}
		int total_sum = 0;
		for(i=0;i<list.size();i++) {
			total_sum += list.get(i);
			System.out.println(list.get(i));
		}
		System.out.println("The sum of the numbers: "+total_sum);
	}
}
