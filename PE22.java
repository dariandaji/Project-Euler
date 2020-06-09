import java.io.*;
import java.util.*;
class PE22 {
	public static void main(String args[])throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		BufferedReader stdin = new BufferedReader(new FileReader("p022_names.txt"));
		String line = "";
		
		while((line = stdin.readLine())!=null) {
			String[] dataNames = line.split(",");
			
			for(String item : dataNames) {
				String newItem = item.substring(1, item.length()-1); //get rid of ""
				names.add(newItem);
			}
		}
		
		stdin.close();
		Collections.sort(names);
		//System.out.println(names.get(937));
		char ch;
		String s="";
		int sum=0, final_sum=0;
		for(int i=0;i<names.size();i++) {
			s = names.get(i);
			sum=0;
			for(int j=0;j<s.length();j++) {
				ch = s.charAt(j);
				sum+=(int)(ch-64);
			}
			sum = sum * (i+1);
			final_sum += sum;
		}
		System.out.println("The total sum of all name scores: " + final_sum);
	}
} 
