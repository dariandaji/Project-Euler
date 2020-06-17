/*
https://www.mathblog.dk/project-euler-69-find-the-value-of-n-%E2%89%A4-1000000-for-which-n%CF%86n-is-a-maximum/
https://www.geeksforgeeks.org/eulers-totient-function/
Euler Totient function has the formula as stated in the links above
Since we have to find the ratio of n/phi(n)
We can simply divide the formula by n and then inverse it
That means we now simply have to find the lowest possible value of prod(1-1/p)
as its in the denominator
Now, we can simply find its lowest value by multiplying all them prime values
and the moment we get the highest value less than a million we stop 
*/


import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;
class PE69 {
    public static void main(String args[]) throws Exception {
        Sieve_of_Eratosthenes ob = new Sieve_of_Eratosthenes();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes = ob.sieve(1000000);
        int product = 1;
        int i=0;
        while(product*primes.get(i)<1000000) {
            product *= primes.get(i);
            i++;
        }
        System.out.println("The number with the lowest ratio is: "+product);
    }
}