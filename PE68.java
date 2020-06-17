//https://radiusofcircle.blogspot.com/2017/05/project-euler-problem-68-solution-with-python.html
//the structure of letters is the same as seen in the solution given above
/*
We are simply fitting in all numbers, starting with the first 4 (a,b,c,d)
With these 4, we can find the value of e as (a+b+c) == (d+c+e) -> a+b-d = c
Keep doing this for all the characters and add them to a list
Finally, discard all the 17 length strings as they aren't acceptable
and print the one with the highest value
*/
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;
class PE68 {
    public static void main(String args[])throws Exception {
        ArrayList<String> solutions = new ArrayList<String>();
        String sol = "";
        int a,b,c,d,e,f,g,h,i,j;

        for(a=1;a<=10;a++) {
            for(b=1;b<=10;b++) {
                if(b==a) continue;
                for(c=1;c<=10;c++) {
                    if(c==a||c==b) continue;
                    for(d=1;d<=10;d++) {
                        if(d<=a||d==b||d==c) continue;  //d must not be less than a as we intend a to be the lowest external node
                        e = a+b-d;  //because a+b+c = d+c+e
                        if(e<1) break;
                        for(f=1;f<=10;f++) {
                            if(f==e||f==d||f==c||f==b||f<=a) continue;  //f must not be less than  a
                            g=d+c-f;
                            if(g<1) break;
                            if(g==f||g==e||g==d||g==c||g==b||g==a) continue;
                            for(h=1;h<=10;h++) {
                                if(h==g||h==f||h==e||h==d||h==c||h==b||h<=a) continue;  //h must not be less than a
                                i = f+e-h;
                                if(i<1) break;
                                if(i==h||i==g||i==f||i==e||i==d||i==c||i==b||i==a) continue;    
                                j = a+c-i;
                                if(j<1) break;
                                if(j==i||j==h||j==g||j==f||j==e||j==d||j==c||j==b||j<=a) continue;  //j must not be less than a
                                sol="";
                                sol = Integer.toString(a)+Integer.toString(b)+Integer.toString(c)
                                     +Integer.toString(d)+Integer.toString(c)+Integer.toString(e)
                                     +Integer.toString(f)+Integer.toString(e)+Integer.toString(g)
                                     +Integer.toString(h)+Integer.toString(g)+Integer.toString(i)
                                     +Integer.toString(j)+Integer.toString(i)+Integer.toString(b);
                                solutions.add(sol); 
                            } 
                        }
                    }
                }
            }
        }
        longest_string(solutions);
    }

    public static void longest_string(ArrayList<String> solutions) {
        String max = "";
        int i;
        for(i=0;i<solutions.size();i++) {
            if(solutions.get(i).length()!=16) continue;
            if(solutions.get(i).compareTo(max)>0) max = solutions.get(i);
        }
        System.out.println("The highest valued 16-digit string is: "+max);
    }
}