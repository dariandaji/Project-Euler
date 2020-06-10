import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class PE58 {
	public static void main(String args[])throws Exception {
		int side = 3; //starting with a square of side 3
		int diag[] = new int[4];	//store the value of each digonal starting at the 
									//top right diagonal and moving clockwise
		diag[0] = 3;
		diag[1] = 9;
		diag[2] = 7;
		diag[3] = 5;							
									
		int diff[] = new int[4];
		diff[0] = 3-1;
		diff[1] = 9-1;
		diff[2] = 7-1;
		diff[3] = 5-1;
		float ratio = 1.0f;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		ArrayList<Integer> non_primes = new ArrayList<Integer>();
		
		primes.add(3);
		primes.add(5);
		primes.add(7);
		non_primes.add(9);
		
		int i,j;
		for(i=1;;i++) {
			side+=2;
			for(j=0;j<4;j++) {
				diff[j] += 8;
				diag[j] += diff[j];
				
				if(check_prime(diag[j]))
					primes.add(diag[j]);
				else non_primes.add(diag[j]);			
			}
			
			ratio = (float)primes.size()/(float)(non_primes.size()+primes.size()+1); //+1 to include the central 1
			System.out.println(primes.size()+"/"+(non_primes.size()+primes.size()+1)+" = "+ratio + "(for side "+side+")");
			if(primes.size() * 10 < (non_primes.size()+primes.size()+1)) {	//avoids the complication of float
				System.out.println("The side of the square is: "+side);
				System.exit(0);
			}
		}
	} 
	
	public static boolean check_prime(int a) {
		int i;
		for(i=2;i<=Math.sqrt(a);i++)
			if(a%i==0)
				return false;
		return true;
	}
}
