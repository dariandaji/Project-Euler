import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE61 {
	
	static int check[] = new int[6];	//check to see which number polygonals are already in the set
										//0 means not present and 1 means present 
	
	public static void main(String args[])throws Exception {
		long startTime = System.currentTimeMillis();
		int i,j,k,l,m,n;
		StringBuilder s[] = new StringBuilder[6]; 

		for(i=1000;i<10000;i++) {	//last 2 digits cannot start with 0

			s[0] = new StringBuilder(Integer.toString(i));
			if(i%100<10) continue;	//checking if second last digit is a zero	
			
			
			if(isPolygonal(s[0])) {
				s[1] = new StringBuilder(s[0].substring(2,4));
				for(j=10;j<100;j++) {
					s[1].append(j);
					if(compareTo(s[1],s[0])!=0 && isPolygonal(s[1])) {
						s[2] = new StringBuilder(s[1].substring(2,4));
						for(k=10;k<100;k++) {
							s[2].append(k);
							if(compareTo(s[2],s[1])!=0 && compareTo(s[2],s[0])!=0 && isPolygonal(s[2])) {
								s[3] = new StringBuilder(s[2].substring(2,4));
								for(l=10;l<100;l++) {
									s[3].append(l);
									if(compareTo(s[3],s[2])!=0 && compareTo(s[3],s[1])!=0 && compareTo(s[3],s[0])!=0 && isPolygonal(s[3])) {
										s[4] = new StringBuilder(s[3].substring(2,4));
										for(m=10;m<100;m++) {
											s[4].append(m);
											if(compareTo(s[4],s[3])!=0 && compareTo(s[4],s[2])!=0 && 
												compareTo(s[4],s[1])!=0 && compareTo(s[4],s[0])!=0 && isPolygonal(s[4])) {
												s[5] = new StringBuilder(s[4].substring(2,4));
												s[5].append(s[0].substring(0,2));
												if(compareTo(s[5],s[4])!=0 && compareTo(s[5],s[3])!=0 && compareTo(s[5],s[2])!=0 && 
													compareTo(s[5],s[1])!=0 && compareTo(s[5],s[0])!=0 && isPolygonal(s[5])) {
													if(compare(s)) {
														System.out.println("The set is: ");
														System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+s[4]+" "+s[5]);
														int sum = Integer.parseInt(s[0].toString()) + Integer.parseInt(s[1].toString()) + 
																  Integer.parseInt(s[2].toString()) + Integer.parseInt(s[3].toString()) +
																  Integer.parseInt(s[4].toString()) + Integer.parseInt(s[5].toString());
														System.out.println("Total sum is: "+sum);
														long endTime = System.currentTimeMillis();
														System.out.println("Total execution time: "+(endTime - startTime)+"ms");
														System.exit(0);
													}
													s[5].delete(2,4);
												}
											}
											s[4].delete(2,4);
										}
									}
									s[3].delete(2,4);
								}
							}
							s[2].delete(2,4);
						}
					}
					s[1].delete(2,4);
				}
			}
		}
	}
	
	public static boolean isPolygonal(StringBuilder sb) {
		int n = Integer.parseInt(sb.toString());
		if(isOctagonal(n) || isHeptagonal(n) || isHexagonal(n) || isPentagonal(n) || isSquare(n) || isTriangle(n))
			return true;
		return false;
	}
	
	public static boolean isTriangle(int i) {
		double n = (Math.sqrt((8*i)+1)-1)/2;
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean isSquare(int i) {
		double n = Math.sqrt(i);
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean isPentagonal(int i) {
		double n = (Math.sqrt((24*i)+1)+1)/6;
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean isHexagonal(int i) {
		double n = (Math.sqrt((8*i)+1)+1)/4;
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean isHeptagonal(int i) {
		double n = (Math.sqrt((40*i)+9)+3)/10;
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean isOctagonal(int i) {
		double n = (Math.sqrt((3*i)+1)+1)/3;
		if((int)n==n) return true;
		return false;
	}
	
	public static boolean compare(StringBuilder s[]) {
		int i;
		for(i=0;i<check.length;i++)
			check[i]=0;
		
		for(i=0;i<s.length;i++) {
			if(isOctagonal(Integer.parseInt(s[i].toString()))) {
				if(check[0]==1) return false;
				check[0]++;
				continue;
			}
			if(isHeptagonal(Integer.parseInt(s[i].toString()))) {
				if(check[1]==1) return false;
				check[1]++;
				continue;
			}
			if(isHexagonal(Integer.parseInt(s[i].toString()))) {
				if(check[2]==1) return false;
				check[2]++;
				continue;
			}
			if(isPentagonal(Integer.parseInt(s[i].toString()))) {
				if(check[3]==1) return false;
				check[3]++;
				continue;
			}
			if(isSquare(Integer.parseInt(s[i].toString()))) {
				if(check[4]==1) return false;
				check[4]++;
				continue;
			}
			if(isTriangle(Integer.parseInt(s[i].toString()))) {
				if(check[5]==1) return false;
				check[5]++;
				continue;
			}
		}
		
		for(i=0;i<6;i++) 
			if(check[i]>=1)
				continue;
			else return false;
		
		return true;
	}
	
	public static int compareTo(StringBuilder str1, StringBuilder str2) {
		if((str1.toString()).compareTo(str2.toString())==0) 
			return 0;
		return 1;
	}		
}
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
														
