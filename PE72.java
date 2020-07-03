/*
https://www.mathblog.dk/project-euler-72-reduced-proper-fractions/
All numerators which are smaller than and relatively prime to denominator must be found
This is the same as the Euler Totient function calculated for several denominators
The idea is that we are trying to calculate the relatively primes for every number 
starting from 2 to 10^6. Now, we can define that as a summation of all Euler totient 
functions starting from 2 to 10^6. 
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
class PE72 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        int i,j;
        int limit = 1000000;
        int phi[] =new int[limit+1];
        for(i=0;i<=limit;i++) phi[i] = i; //initiate phi to each values number -> to multiply with its prime numbers
        long result = 0;
    
        for(i=2;i<=limit;i++) {
            if(phi[i]==i) {  //only values not changed in previous iterations are multiplied i.e. prime numbers
                for(j=i;j<=limit;j+=i) {  //finding multiples of i and using euler's totient function
                    phi[j] = phi[j]/i * (i-1);  //p*(1 - 1/p)
                }
            }
            result += phi[i];   //add all values of phi whether calculated previously or in this step as a prime
        }
    
        long endTime = System.currentTimeMillis();
        System.out.println("Total number of proper fractions: "+result);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }
}