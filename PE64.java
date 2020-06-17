//https://radiusofcircle.blogspot.com/2016/11/project-euler-problem-64-solution-with-python.html
//follow the formulae given in the link above to solve this question
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class PE64 {
    static int count = 0;
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        int i;
        
        for(i=1;i<=10000;i++)
            find_period(i);

        long endTime = System.currentTimeMillis();
        System.out.println("Total count of odd periods: "+ count);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }

    public static void find_period(int i) {
        int a0 = (int)Math.sqrt(i);

        int an = a0;
        int period = 0;
        double mn = 0.0;
        double dn = 1.0;

        if(a0 != Math.sqrt(i)) {
            while(an != 2*a0) {
                mn = dn * an - mn;
                dn = (i - Math.pow(mn,2))/dn;
                an = (int)((a0 + mn)/dn);
                period++;
            }
            if(period%2==1)
                count++;
        }
    }
}