import java.io.*;
class PE17 {
	public static void main(String args[]) throws IOException {
 		String words[][] = {
 		{"", "one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten", "eleven","twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}, 
 		{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty","ninety"}
 		};
 		
 		String name="";
 		int i,j,k;
 		char ch;
 		int cnt=0;
 		
 		for(i=1;i<1000;i++) {
 			name = "";
 			
 			if(i/100 > 0) {
 				name = name+words[0][(int)i/100]+" hundred";
 				if(i%100 > 0) name = name + " and";
 			}
 			if(i%100>0) {
 				if(i%100<20) name = name+" "+words[0][i%100];
 				else {
 					j=i%100;
 					name = name + " " + words[1][((int)(j/10))-2]+" "+words[0][j%10];
 				}
 			}
 			System.out.println(name);
 			
 			for(k=0;k<name.length();k++) {
				ch = name.charAt(k);
				if(ch>=97 && ch<=122) cnt++;
 			}
 		}
 		name = "one thousand";
 		System.out.println(name);
 		cnt+=name.length()-1; //remove space value, hence, -1
 		
 		
 		System.out.println("\nThe total character count is: "+cnt);

 	}
}
