import java.io.*;
public class PE14 {
	public static void main(String args[]) throws IOException {
		int terms;
		int n, store;
		int longest_chain_no=2;
		int max_terms=0;
		for(n=2;n<1000000;n++) {
			store = n;
			terms = 1;	
			do {
				if(n%2==0) n/=2;
				else n=(3*n+1);
				terms++;
			}while(n!=1);
			
			if(terms>max_terms) {
				max_terms = terms;
				longest_chain_no = store;
			}
		}
		System.out.println("Longest Chain Number = " + longest_chain_no+"\nTerms = "+max_terms);  
	}
}
			
