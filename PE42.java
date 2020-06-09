import java.io.*;
import java.util.*;
class PE42 {
	static ArrayList<Integer> triangles = new ArrayList<Integer>();
	public static void main(String args[])throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader("p042_words.txt"));
		String line = "";
		ArrayList<String> words = new ArrayList<String>();	
		while((line = stdin.readLine())!=null) {
			String[] dataWords = line.split(",");
			for(String item : dataWords) {
				String newWord = item.substring(1,item.length()-1);
				words.add(newWord);
			}
		}
		
		stdin.close();
		int i,j,calc;
		for(i=1;;i++) {
			calc = (i*(i+1))/2;
			triangles.add(calc);
			if(calc>400) //15 Z's would be 390. Hence, we stop at this number
				break;
		}
		
		int sum = 0;
		int cnt = 0;
		for(i=0;i<words.size();i++) {
			sum=0;
			for(j=0;j<words.get(i).length();j++)
				sum+= ((int)(words.get(i)).charAt(j))-64;	//A = 65-64 = 1
			if(isTriangle(sum)) {
				System.out.println(words.get(i) + " = "+sum);
				cnt++;
			}
		}
		System.out.println("Total number of triangle words = "+cnt);
	}
	
	public static boolean isTriangle(int sum) {
		int i;
		for(i=0;i<triangles.size();i++) 
			if(triangles.get(i)==sum)
				return true;
		return false;
	}
}
