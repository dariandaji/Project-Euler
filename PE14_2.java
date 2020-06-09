import java.io.*;
public class PE14_2 {
	public static void main(String args[])throws IOException {
		int n, terms, max_terms=0, max_no=0;
		long store;
		int cache[] = new int[1000001];
		for(int i=0;i<cache.length;i++)
			cache[i] = -1;
		
		cache[1]=1;
		for(n=2;n<1000000;n++) {
			store = n;
			terms = 0;
			while(store!=1 && store>=n) {
				terms++;
				if(store%2==0) store=store/2;
				else store=(3*store+1);
			}
			cache[n] = terms+cache[(int)store];
			
			if(cache[n] > max_terms) {
				max_terms = cache[n];
				max_no = n;
			}
		}
		System.out.println("Largest Collatz Sequence = "+max_terms+" for the Starting Number = "+max_no);
	}
}
