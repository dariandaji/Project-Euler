//Use dynamic programming to solve this problem
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE76 {
    public static void main(String args[])throws Exception {
        long startTime = System.currentTimeMillis();
        int ways[] = new int[101];
        ways[0] = 1;
        int i,j;
        for(i=1;i<100;i++) {
            for(j=i;j<=100;j++) {
                ways[j] += ways[j-i];
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The total number of ways to get 100: "+ways[100]);
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }
}
