import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE74 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        int i,n,last,count,total_chains=0;
        for(i=1;i<=1000000;i++) {
            n=i;
            last = 0;
            count = 0;
            while(n!=last && n!=169 && n!=363601 && n!=1454 && n!=871 && n!=45361 && n!=872 && n!=45362) { //n!=last checks for a condition such as 145
                last = n;
                n = add_digits(n);
                count++;        
            }                                                                                           

            if(count==57 && (n==169 || n==36301 || n==1454))    //only such a condition ensures sum is 60 and the 61st term is a repeating sequence
                total_chains++;
        }
        System.out.println("Total number of chains of length 60: "+total_chains);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }

    public static int add_digits(int n) {
        int[] factorial = {1,1,2,6,24,120,720,5040,40320,362880};
        int x = n;
        int sum=0;
        while(x>0) {
            sum += factorial[x%10];
            x /= 10;
        }
        return sum;
    }
}