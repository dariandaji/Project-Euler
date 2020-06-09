/*
We have used combinatorics here. For example, place 0 at the first place. The remaining 9 blanks can be filled in 9! ways i.e. 362880. Start with 1 and another 362880 ways. But the next interval exceeds this value. So we know first digit is 2. Then, we start from 0 again. Remaining 8 places filled in 8! ways. Keep doing this till we get the millionth permutation
*/

import java.io.*;
import java.util.*;
class PE24 {
	public static void main(String args[])throws IOException {
		char digits[] = {'0','1','2','3','4','5','6','7','8','9'};
		ArrayList<Character> used = new ArrayList<Character>();
		int i,j	;
		int blanks;
		int permutations=0, permutation_sum=0;
		int flag=0;
		int k=0;	//control variable to remove the last character when permutation sum is less than 1000000
		for(i=0;i<digits.length;i++) {	//controls which digit is added to 'used'list
			//System.out.println("i: "+i);
			flag=0;
			for(j=0;j<used.size();j++) {
				if(digits[i]==used.get(j)) {
				//	System.out.println("Used"+digits[i]);
					flag = 1;			
					break;
				}
			}
			
			if(flag==0) used.add(digits[i]);
			else continue;
			
			blanks = 10-used.size();
			permutations = factorial(blanks);
			if(permutations+permutation_sum < 1000000) {
				used.remove(k);
				permutation_sum += permutations;
				//System.out.println(permutation_sum);
				continue;
			}
			//System.out.println(used.get(k));
			k++;
			i=-1;	//when loop reiterates, it becomes i++ = 1
		}
		System.out.print("The "+(permutation_sum+1)+"th permutation is: ");
		for(i=0;i<used.size();i++)
			System.out.print(used.get(i));
		System.out.println();
	}
	public static int factorial(int a) {
		int i,fact=1;
		for(i=1;i<=a;i++)
			fact*=i;
		return fact;
	}	
}
