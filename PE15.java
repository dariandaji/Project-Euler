import java.io.*;
import java.math.*;
class PE15 {
	public static void main(String args[])throws IOException {
		//whenever a lattice in question asks you to reach (a,b) from (0,0)
		//the solution is given by (a+b)Ca 
		int a=20,b=20;
		BigInteger total_paths = factorial(a+b);
		total_paths = total_paths.divide(factorial(a));
		total_paths = total_paths.divide(factorial(b));
		System.out.println("The total number of paths is: "+total_paths);
	}
	public static BigInteger factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for(int i=1;i<=n;i++)
			fact = fact.multiply(new BigInteger(String.valueOf(i)));
		return fact;
	}
}
