import java.io.*;
import java.math.*;
public class PE13 {
	public static void main(String args[])throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the numbers:");
		String s[] = new String[100];
		BigInteger sum = new BigInteger("0");
		
		for(int i=0;i<100;i++) {
			s[i] = stdin.readLine();
			sum = sum.add(new BigInteger(s[i]));
		}
		System.out.println("\n\nResult of addition = " +sum);
	}
}

