/*
https://www.mathblog.dk/project-euler-70-investigate-values-of-n-for-which-%CF%86n-is-a-permutation-of-n/#:~:text=Project%20Euler%2070%3A%20Investigate%20values,is%20a%20permutation%20of%20n.&text=Euler's%20Totient%20function%2C%20%CF%86(%20n,are%20relatively%20prime%20to%20n%20.

The solution is similar to the one stated in the link above
We have to minimize the value of n/phi(n)
To do this, we have to ensure phi(n) is as large as possible
This is done by having as few terms in the denominator (as they are all smaller than 1)
and those terms must be large so that they reduce the term (1-1/p) as low as possible

Now, the multiplication of those numbers must not exceed 10^7
Hence, if we consider the minimum number of terms as 2 (1 is not possible) and multiply them,
they should be somewhere around root(10^7) ~ 3162.
So we can find all prime numbers less than 10000, multiply them 2 at a time and 
check whether they satisfy the permutation condition
phi(n) = n*(1-1/p1)*(1-1/p2) {for a 2 prime number}
and, n = p1.p2 in our case
So, phi(n) = (p1-1)*(p2-1) 
*/

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE70 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        Sieve_of_Eratosthenes ob = new Sieve_of_Eratosthenes();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes = ob.sieve(10000);

        int i,j;
        long n, phi, opt_n=0, opt_phi=0;
        double ratio, min_ratio=primes.get(primes.size()-1);

        for(i=0;i<primes.size();i++)    //set the value of i so that all primes are 4 digits
            if(primes.get(i)>1000)
                break;


        for(;i<primes.size();i++) { //set the value of i to what we calculated in the previous step
            for(j=i+1;j<primes.size();j++) {
                n = primes.get(i) * primes.get(j);
                if(n>Math.pow(10,7)) break;
                phi = (primes.get(i)-1) * (primes.get(j)-1);
                ratio = (double)n/phi;
                if(ratio<min_ratio && isPermutation(n,phi)) {
                    min_ratio = ratio;
                    opt_phi = phi;
                    opt_n = n;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The value of n for the lowest ratio is: "+opt_n);
        System.out.println("The lowest ratio is: "+min_ratio);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }

    public static boolean isPermutation(long n, long phi) {
        String s1 = Long.toString(n);
        String s2 = Long.toString(phi);
        if(s1.length()!=s2.length()) return false;

        int i;
        int digits1[] = new int[10];
        int digits2[] = new int[10];
        for(i=0;i<s1.length();i++) {
            digits1[s1.charAt(i)-48]++;
            digits2[s2.charAt(i)-48]++;
        }

        for(i=0;i<10;i++)
            if(digits1[i]!=digits2[i])
                return false;

        return true;
    }
}
