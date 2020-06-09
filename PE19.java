import java.io.*;
class PE19 {
	public static void main(String args[])throws IOException {
		String weekdays[] = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		String firsts[] = new String[1212];	//stores the first of each month for 101 years (i.e. 1900 to 2000)
		firsts[0] = "Monday";	//1st Jan, 1900
		
		int days=0;
		int month=1;
		int year = 1900;
		int i=1;
		int cnt_sun=0;
		while(year!=2001) {	
			if(month==1 || month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==0) { //Dec counts as 12%12 = 0
				days+=31;
				if(month==0)
					if(year==2000) break;
				else year++;
				firsts[i] = weekdays[(days+1)%7];
			}
			
			else if(month==4 ||month==6 ||month==9 ||month==11) {
				days+=30;
				firsts[i] = weekdays[(days+1)%7];
			}
			
			else if(month==2) {
				if(year%4==0) {
					if(year%100==0 && year%400!=0)
						days+=28;
					else days+=29;
				}
				else days+=28;
				firsts[i] = weekdays[(days+1)%7];
			}
			month = (++month)%12;
			System.out.println(month+" "+year+" "+firsts[i]);
			i++;	
		}
		for(i=12;i<firsts.length;i++)	//we have to count from 1901 hence skip the values 0 to 11
			if(firsts[i].compareTo("Sunday")==0) cnt_sun++;
		System.out.println("Total number of Sundays: "+cnt_sun);
	}
}
