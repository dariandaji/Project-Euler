import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE67 {
    static int a[][] = new int[100][100];
    public static void main(String args[])throws Exception {
        BufferedReader stdin = new BufferedReader(new FileReader("p067_triangle.txt"));
        String s;
        int i,j;

        i=0;
        while((s=stdin.readLine())!=null) {
            String store[] = s.split(" ");
            for(j=0;j<store.length;j++) {
                a[i][j] = Integer.parseInt(store[j]);
            }
            i++;
        }

/*      for(i=0;i<100;i++) {
            for(j=0;j<=i;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }*/

        find_highest_path();
    }

    public static void find_highest_path() {    //dynamic programming - bottom to top
        int i,j;
        for(i=a.length-2;i>=0;i--) {
            for(j=0;j<=i;j++) {
                a[i][j] += Math.max(a[i+1][j], a[i+1][j+1]);    //add and store in the same array location using dynamic programming
            }
        }
        System.out.println("Highest Total: "+a[0][0]);
        System.exit(0);
    }
}