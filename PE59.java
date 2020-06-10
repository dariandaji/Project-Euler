import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE59 {
	public static void main(String args[])throws Exception {
		BufferedReader stdin = new BufferedReader(new FileReader("p059_cipher.txt"));
		String line = stdin.readLine();
		String cipher[] = line.split(",");
		int i,j,k;	//these contain the encryption key
		int cnt=0;
		char c1, c2, c3;
		encrypt_text(101,120,112,cipher);
		for(i=97;i<=122;i++) {
			for(j=97;j<=122;j++) {
				for(k=97;k<=122;k++) {
					cnt = 0;
					while(cnt!=cipher.length-3) {
						c1 =(char)(Integer.parseInt(cipher[cnt]) ^ i);
						c2 = (char)(Integer.parseInt(cipher[cnt+1]) ^ j);
						c3 = (char)(Integer.parseInt(cipher[cnt+2]) ^ k);
						//System.out.print(c1+""+c2+""+c3);
						if(check_word(c1,c2,c3) && encrypt_text(i,j,k,cipher)) {
							System.out.println("Key: "+(char)i+""+(char)j+""+(char)k);
							decipher(i,j,k,cipher);
							System.exit(0);
						}
						cnt++;
					}
				}
			}
		}
	}
	
	public static boolean check_word (char c1, char c2, char c3) {
		//comparing decoded 3 characters to "the" in different forms
		//"the" is the most common English word. Hence, it should yield a decent result
		String s1 = Character.toString(c1) + Character.toString(c2) + Character.toString(c3);
//		System.out.println(s1);
		if(s1.compareTo("the")==0 || s1.compareTo("The")==0 || s1.compareTo("THE")==0)
			return true;
		return false;
	}
	
	public static boolean encrypt_text(int i, int j, int k, String[] cipher) {
		char c1,c2,c3;
		int x;
		for(x=0;x<cipher.length;x+=3) {
			c1 =(char)(Integer.parseInt(cipher[x]) ^ i);
			c2 = (char)(Integer.parseInt(cipher[x+1]) ^ j);
			c3 = (char)(Integer.parseInt(cipher[x+2]) ^ k);
			if(!(c1>=32 && c1<=122 && c2>=32 && c2<=122 && c3>=32 && c3<=122))
				return false;
		}
		return true;
	}
	
	public static void decipher(int i, int j, int k, String[] cipher) {
		char c1,c2,c3;
		int x;
		String s = "";
		int sum = 0;
		for(x=0;x<cipher.length;x+=3) {
			c1 =(char)(Integer.parseInt(cipher[x]) ^ i);
			c2 = (char)(Integer.parseInt(cipher[x+1]) ^ j);
			c3 = (char)(Integer.parseInt(cipher[x+2]) ^ k);
			sum += (int)(c1+c2+c3);
			s += Character.toString(c1) + Character.toString(c2) + Character.toString(c3);
		}
		System.out.println(s);
		System.out.println("Ascii Sum: "+sum);
	}
}
	
