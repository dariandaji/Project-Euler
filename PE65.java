/*
The solution is given in the question
There is a repetitive pattern in the CF of e
1,2,1,1,4,1,1,6,1,1,8,...
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE65 {
    public static void main(String args[]) throws Exception {
        long startTime = System.currentTimeMillis();
        int a[] = new int[99];  //99th (index 98) value will give 100th convergent
        int i;
        for(i=0;i<99;i++)   a[i] = 1;
        
        int cnt=1;
        for(i=1;i<99;i+=3)  a[i] = 2*cnt++;
    
        evaluate_expr(a);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }

    public static void evaluate_expr(int a[]) {
        BigInteger num, den; //store calculated num and den;
        BigInteger num2, den2; //used for calculating the num and den for each iteration
        
        num = new BigInteger("1");
        den = new BigInteger(Integer.toString(a[a.length-1]));    //for bottom to top evaluation
        int i;

        BigInteger temp;
        for(i=a.length-2;i>=0;i--) {
            temp = new BigInteger(Integer.toString(a[i]));
            num2 = temp.multiply(den);
            num2 = num2.add(num);
            den2 = den;

            num = den2;
            den = num2;
            //System.out.println(num+"/"+den);
        }
        //int final_num = 2*den + num;    //adding a0 value = 2
        //System.out.println(final_num);

        BigInteger final_num = den.multiply(new BigInteger("2"));
        final_num = final_num.add(num);
        System.out.println("Final numerator: "+final_num);
        calculate_digits(final_num);
    }

    public static void calculate_digits(BigInteger final_num) {
        String s = final_num.toString();
        int i, sum=0;
        for(i=0;i<s.length();i++) {
            sum += (int)(s.charAt(i)-48);
        }
        System.out.println("Sum of digits: "+sum);
    }
}