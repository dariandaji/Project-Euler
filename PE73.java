/*
The idea here is to consider every denominator from 1 to 12000
For every denominator, calculate the numerator as ceiling(1/3 of denominator)
Doing this ensures that the numerator is greater than (or exactly 1/3rd) of the denominator
Finally, check if the fraction is >1/3. If not, increment the numerator by 1 and at each stage 
check if the fraction is not exceeding 1/2. Add all such fractions to the list. If fraction becomes 
>=1/2 continue with the next denominator value. 
Sort the final list and count non-duplicate values
---> There is another possible solution using Farey sequences too alternately
*/
import java.io.*;
import java.math.*;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;
class PE73 {
    public static void main(String args[]) throws Exception {
        int num,den;
        long startTime = System.currentTimeMillis();
        ArrayList<Double> list = new ArrayList<Double>();
        for(den=1;den<=12000;den++) {
            num = (int)Math.ceil((double)den/3.0);
            while((double)num/(double)(den)<0.5) {
                if(den==3*num){
                    num++;
                    continue;
                }            
                list.add((double)num/(double)den);
                //System.out.println(num+"/"+den);
                num++;
            }
        }
        List<Double> newList = list.stream().distinct().collect(Collectors.toList());   //convert ArrayList to a new List with only distinct elements inserted
        long endTime = System.currentTimeMillis();
        System.out.println("Total size: "+newList.size());
        System.out.println("Total execution time: "+(endTime-startTime)+"ms");
    }
}