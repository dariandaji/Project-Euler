import java.io.*;
class PE21 {
	public static void main(String args[])throws IOException {
		int amicable[] = new int[100];
		int i,j,k=0;
		int div_sum = 0;
		int newno;
		for(i=4;i<10000;i++) {
			j=1;
			div_sum=0;
			while(j<i) {
				if(i%j==0) 
					div_sum += j;
				j++;
			}	
			newno = div_sum;
			div_sum=0;
			j=1;
			while(j<newno) {
				if(newno%j==0)
					div_sum += j;
				j++;
			}		
			if(div_sum==i) {
				amicable[k] = i;
				amicable[k+1] = newno;
				k+=2;
			}
		}
		
		int amicable_sum = 0;
		for(i=0;i<amicable.length;i+=2) {
			if(amicable[i]!=0 && amicable[i+1]!=0 && (amicable[i]!=amicable[i+1])) {
				System.out.print(amicable[i]+" "+amicable[i+1]);
				System.out.println();
				amicable_sum += (amicable[i]+amicable[i+1]);
			}
		}
		System.out.println("Sum of all amicable numbers is: " + amicable_sum/2); //to remove the duplicate sets
	}
}
