//Use dynamic programming to solve this problem
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE76 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Sieve_of_Eratosthenes soe = new Sieve_of_Eratosthenes();
        primes = soe.sieve(1000);
        int i,j;
        int final_sol = 2;
        while(true) {
            int ways[] = new int[final_sol+1];
            ways[0] = 1;    //has to be initialised otherwise loop will run to infinity
            for(i=0;i<primes.size();i++) {
                for(j=primes.get(i);j<=final_sol;j++) {
                    ways[j] += ways[j-primes.get(i)];
                }
            }
            if(ways[final_sol]>5000) break;
            final_sol++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The first number that can be formed in over 5000 ways: "+final_sol);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }
}
