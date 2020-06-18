import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE62 {
	public static void main(String args[])throws Exception {
		long startTime = System.currentTimeMillis();
		ArrayList<String> cubes = new ArrayList<String>();
		int i;
		BigInteger n;
		for(i=0;;i++) {
			n = new BigInteger(Integer.toString(i));
			n = n.pow(3);
			add_list(n, cubes);
			if(check_cnt(cubes)) {
				long endTime = System.currentTimeMillis();
				System.out.println("Total execution time: "+(endTime-startTime)+"ms");
				System.exit(0);
			}
		}
	}
	
	public static void add_list(BigInteger n, ArrayList<String> cubes) {
		StringBuilder s = new StringBuilder(n.toString());
		int i,j;
		char temp;
		
		for(i=0;i<s.length();i++) {
			for(j=0;j<s.length()-1-i;j++) {
				if(s.charAt(j)>s.charAt(j+1)) {
					temp = s.charAt(j+1);
					s.setCharAt(j+1,s.charAt(j));
					s.setCharAt(j, temp);
				}
			}
		}
		System.out.println(s);
		cubes.add((s.toString()));	
	}
	
	public static boolean check_cnt(ArrayList<String> cubes) {
		String x = cubes.get(cubes.size()-1);
		int i,cnt=0;
		String smallest = "";
		for(i=0;i<cubes.size()-1;i++) {
			if(cubes.get(i).compareTo(x)==0) {
				cnt++;
				if(cnt==1) { //encountered the first instance just now
					smallest = Double.toString(Math.pow(i,3));	//since all elements stored in list in the same order of entry
				}
			}
		}
					
					
					
					
		
		if(cnt==4) {	//4 previous entries and adding the last makes it 5
			System.out.println("The smallest cube is: "+smallest);	
			return true;
		}
		return false;
	}
}	
