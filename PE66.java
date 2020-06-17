//https://en.wikipedia.org/wiki/Diophantine_equation
//https://en.wikipedia.org/wiki/Pell%27s_equation
//https://www.isibang.ac.in/~sury/chakravala.pdf - Chakravala Algorithm
//The implementation here is one similar to the one on the mathblog.dk website
/*
What i am trying to do here is, 
1) Take a value of D starting from 1 to 10000
2) Find the CF for sqrt(D)  (from PE64)
3) Find the convergents for the CF of D that we obtain (from the mathblog.dk formulae)
4) Push these convergents into the the equation
5) If the final value of the equation is 1, that's our minimal solution
*/
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;

class PE66 {
    static ArrayList<Integer> cf = new ArrayList<Integer>();
    static int result = 0;
    static BigInteger max_x = new BigInteger("0");
    public static void main(String args[]) throws Exception {
        long startTime = System.currentTimeMillis();
        int D;
        for(D=2;D<=1000;D++) {
            if((int)Math.sqrt(D)==Math.sqrt(D)) continue;

            cf.clear();
            find_cf(D);
            find_convergents(D);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The largest x valued "+max_x+" is achieved for the value of D = "+result);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }


    public static void find_cf(int i) {
        int a0 = (int)Math.sqrt(i);
        cf.add(a0);
        int an = a0;
        double mn = 0.0;
        double dn = 1.0;

        if(a0 != Math.sqrt(i)) {
            while(an != 2*a0) {
                mn = dn * an - mn;
                dn = (i - Math.pow(mn,2))/dn;
                an = (int)((a0 + mn)/dn);
                cf.add(an);

            }
        }
        //System.out.println(i+" -> "+cf);

    }

    public static void find_convergents(int i) {
/*
        BigInteger m = new BigInteger("0");
        BigInteger d = new BigInteger("1");
*/

        BigInteger a;
        BigInteger ONE = new BigInteger("1");   //to compare with expr to see if it has value 1

        BigInteger num1 = new BigInteger("1");  //n(-1) initialised to 1
        BigInteger num = new BigInteger(Integer.toString(cf.get(0)));   //n(0), initialised to the value of a(0)
                                                                        //a(0) is then removed from the list as it interferes with computation

        BigInteger den1 = new BigInteger("0");  //d(-1) initialised to 0
        BigInteger den = new BigInteger("1");   //d(0) initialised to 1

        BigInteger i1 = new BigInteger(Integer.toString(i));
        BigInteger expr = num.multiply(num);    //compute expr to be checked in the first iteration of the loop
        expr = expr.subtract(i1.multiply(den.multiply(den)));

        cf.remove(0);   //remove a0 from the list to carry on successive iteration
        int k=0;    //control variable to get cf values from the list
        while(expr.compareTo(ONE)!=0) {    //x^2 - D *y^2 = 1 (Pell's Equation)
            BigInteger num2 = num1; //num2 stores n(i-2) value, initialised to n(i-1) for the current iteration
            num1 = num;             //num1 then initialised to num

            BigInteger den2 = den1;
            den1 = den;

            //equation -> n(i) = a(i)*n(i-1) + n(i-2)
            a = new BigInteger(Integer.toString(cf.get(k%cf.size())));
            num = a.multiply(num1);
            num = num.add(num2);

            //equation -> d(i) = a(i)*d(i-1) + d(i-2)
            den = a.multiply(den1);
            den = den.add(den2);

            //check Pell's equation condition -> num*num - D*den*den = 1
            expr = num.multiply(num);
            expr = expr.subtract(i1.multiply(den.multiply(den)));

            k++;    //for next value from cf list and since its repetitive we just do k%cf.size
        }

       if(num.compareTo(max_x)>0) { //store max value of x and D
            max_x = num;
            result = i;
        }
    }
}