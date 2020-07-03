/*
Since d goes from 1 to 10^6, we can safely estimate the max value of the numerator
will be 3/7 of 10^6 ~ 428572.
So we take values of numerator from 1 to 428572 and calculate the denominator as 
7/3 of that value. If den is an integer, we can add d+1 to the denominator list
as d+1 is the smallest value of the denominator to be less than 3/7
Finally add fractions to a final list, sort it and print the last value 
*/
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class PE71 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        int num;
        double den;
        ArrayList<Integer> numerator = new ArrayList<Integer>();
        ArrayList<Double> denominator = new ArrayList<Double>();
        ArrayList<Double> fraction = new ArrayList<Double>();

        for(num=1;num<428572;num++) {  
            den = 7.0/3.0 * (double)num;
            numerator.add(num);
            denominator.add((double)((int)den)+1.0);    //rounding off the denominator to integer and adding 1 so that it is always greater than 7/3 of numerator 
            fraction.add((double)num/((double)((int)den)+1.0));
        }

        Collections.sort(fraction); //sort so that the largest value less than 3/7 is the last element
        int i;
        for(i=0;i<numerator.size();i++)
            if((double)numerator.get(i)/(double)denominator.get(i)==fraction.get(fraction.size()-1)) {
                if(gcd(numerator.get(i), denominator.get(i))) {  //making sure the fraction is in its most reduced form
                    System.out.println("The numerator is: "+numerator.get(i));
                    System.out.println("The fraction is: "+numerator.get(i)+"/"+denominator.get(i));
                    long endTime = System.currentTimeMillis();
                    System.out.println("Total execution time: "+(endTime-startTime)+"ms");
                }
            }

    }

    public static boolean gcd(int n, double d) {
        int d1 = (int)d;
        int i;
        if(n%2==0 && d1%2==0) return false;
        for(i=3;i<=Math.sqrt(n);i+=2)
            if(n%i==0 && d%i==0) return false;
        return true;
    }
}