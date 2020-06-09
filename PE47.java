import java.io.*;
import java.util.*;
import java.math.*;
class PE47 {
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	public static void main(String args[])throws IOException {
		long startTime = System.currentTimeMillis();
		int i,cnt;
		for(i=2;;i++) {
			if(!isComposite(i)) {
				prime.add(i);
				continue;
			}
			//skip the first 646 numbers
			if(i>646 && primeCount(i)==4 && primeCount(i+1)==4 && primeCount(i+2)==4 && primeCount(i+3)==4) {
				System.out.println("The smallest number is: "+i);
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: "+(endTime-startTime)+"ms");
	}
	
	public static boolean isComposite(int a) {
		int i;
		for(i=2;i<a;i++)
			if(a%i==0)
				return true;
		return false;
	}
	
	public static int primeCount(int a) {
		int j=0,flag=0;
		int cnt=0;
		while(j<prime.size() && a!=1) {	//stop when a becomes 1 i.e. all factors discovered
			if(a%prime.get(j)==0) {
				if(flag==0) cnt++;	//this factor has not been counted before
				flag=1;
				a /= prime.get(j);
			} else {
				flag=0;
				j++;
			}
		}
		return cnt;
	}
}
					
			
