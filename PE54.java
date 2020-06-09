import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class PE54 {
	public static void main(String args[])throws Exception {
		BufferedReader stdin = new BufferedReader(new FileReader("p054_poker.txt"));
		String line = "";
		ArrayList<String> hand1 = new ArrayList<String>();
		ArrayList<String> hand2 = new ArrayList<String>();
		
		while((line = stdin.readLine())!=null) {
			hand1.add(line.substring(0,14));
			hand2.add(line.substring(15));
		}
	
		stdin.close();
		int i,count=0;
		
		for(i=0;i<hand1.size();i++) {
			//System.out.println(hand1.get(i)+" <-> " +hand2.get(i));
			if(compare(hand1.get(i), hand2.get(i))==1) 
				count++;
		}
		//System.out.println(count2);
		System.out.println("Total number of hands won by Player 1: "+count);
	}
	
	public static int compare(String h1, String h2) {
		int rank1=0, rank2=0;
		char hcard1='0', hcard2='0';
		char hcard11='0', hcard22='0';
		int cnt = 0;
		int i;
		
		int suite1 = suite(h1);	//1 if all belong to the same suite
		int suite2 = suite(h2);	//0 otherwise
		
//		if(suite1!=suite2)
	//		return (suite1>suite2)?1:0;
			
		h1 = order(h1);
		h2 = order(h2);
		
		//check for Royal FLush
		if(suite1==1 && h1.charAt(0)=='A' && h1.charAt(3)=='K' && h1.charAt(6)=='Q' && h1.charAt(9)=='J' && h1.charAt(12)=='T') 
			rank1 = 10;
		if(suite2==1 && h2.charAt(0)=='A' && h2.charAt(3)=='K' && h2.charAt(6)=='Q' && h2.charAt(9)=='J' && h2.charAt(12)=='T') 
			rank2 = 10;
		
		//check for Straight Flush
		int flag = 0;
		if(suite1==1 && rank1!=10) {
			for(i=0;i<11;i+=3) {
				if(cardValue(h1.charAt(i)) - cardValue(h1.charAt(i+3)) != 1) {
					flag=1;
					break;
				}
			}
			if(flag==0) rank1 = 9;
		}

			
		flag=0;	
		if(suite2==1 && rank2!=10) {
			for(i=0;i<11;i+=3) {
				if(cardValue(h2.charAt(i)) - cardValue(h2.charAt(i+3)) != 1) {
					flag=1;
					break;
				}
			}
			if(flag==0) rank2 = 9;	
		}
			
		
		//check for Four of a Kind
		if(h1.charAt(0)==h1.charAt(9) || h1.charAt(3)==h1.charAt(12)) {
			hcard1 = h1.charAt(6);
			rank1 = 8;
		}
		if(h2.charAt(0)==h2.charAt(9) || h2.charAt(3)==h2.charAt(12)) {
			hcard2 = h2.charAt(6);
			rank2 = 8;
		}	
		//checking for Full House
		if(h1.charAt(0)==h1.charAt(6) && h1.charAt(9)==h1.charAt(12) || h1.charAt(6)==h1.charAt(12) && h1.charAt(0)==h1.charAt(3)) {
			rank1 = 7;
			for(i=0;i<7;i+=3) {
				if(h1.charAt(i)==h1.charAt(i+3) && h1.charAt(i)==h1.charAt(i+6)) {
						hcard1 = h1.charAt(i);
						cnt++;
				}
			}
			for(i=0;i<10;i+=3) {
				if(h1.charAt(i)==h1.charAt(i+3) && h1.charAt(i)!=hcard1) {
					hcard11 = h1.charAt(i);
					break;
				}
			}
		}
				
			
		if(h2.charAt(0)==h2.charAt(6) && h2.charAt(9)==h2.charAt(12) || h2.charAt(6)==h2.charAt(12) && h2.charAt(0)==h2.charAt(3)) {
			rank2 = 7;
			for(i=0;i<7;i+=3) {
				if(h2.charAt(i)==h2.charAt(i+3) && h2.charAt(i)==h2.charAt(i+6)) {
						hcard2 = h2.charAt(i);
						cnt++;
				}
			}
			for(i=0;i<10;i+=3) {
				if(h2.charAt(i)==h2.charAt(i+3) && h2.charAt(i)!=hcard2) {
					hcard22 = h2.charAt(i);
					break;
				}
			}
		}
		//checking for Flush
		if(rank1==0 && suite1==1) {
			rank1 = 6;
		}
		if(rank2==0 && suite2==1) {
			rank2 = 6;
		}	
		
		//checking for Straight 
		flag=0;
		if(rank1==0) {
			for(i=0;i<11;i+=3) {
				if(cardValue(h1.charAt(i)) - cardValue(h1.charAt(i+3)) != 1) {
					flag=1;
					break;
				}
			}
			if(flag==0) rank1 = 5;
		}
		
		flag=0;
		if(rank2==0) {
			for(i=0;i<11;i+=3) {
				if(cardValue(h2.charAt(i)) - cardValue(h2.charAt(i+3)) != 1) {
					flag=1;
					break;
				}
			}
			if(flag==0) rank2 = 5;
		}
		
		//checking for Three of a Kind
		if(rank1==0)
			if(h1.charAt(0)==h1.charAt(6) || h1.charAt(3)==h1.charAt(9) || h1.charAt(6)==h1.charAt(12)) {
				hcard1 = h1.charAt(6);
				rank1 = 4;
			}
				
		if(rank2==0)
			if(h2.charAt(0)==h2.charAt(6) || h2.charAt(3)==h2.charAt(9) || h2.charAt(6)==h2.charAt(12)) {
				hcard2 = h2.charAt(6);
				rank2 = 4;
			}
			
		//checking for Two Pairs
		cnt = 0;
		if(rank1==0)
			if(h1.charAt(0)==h1.charAt(3) && h1.charAt(6)==h1.charAt(9) || h1.charAt(0)==h1.charAt(3) && h1.charAt(9)==h1.charAt(12) || h1.charAt(3)==h1.charAt(6) && h1.charAt(9)==h1.charAt(12)) {
				rank1 = 3;
				for(i=0;i<10;i+=3) {
					if(h1.charAt(i)==h1.charAt(i+3)) {
						if(cnt==0) {
							hcard1 = h1.charAt(i);
							cnt++;
						}
						if(cnt==1) {
							hcard11 = h1.charAt(i);
							break;
						}
					}
				}
			}
		
		
		
		cnt=0;
		if(rank2==0)
			if(h2.charAt(0)==h2.charAt(3) && h2.charAt(6)==h2.charAt(9) || h2.charAt(0)==h2.charAt(3) && h2.charAt(9)==h2.charAt(12) || h2.charAt(3)==h2.charAt(6) && h2.charAt(9)==h2.charAt(12)) {
				rank2 = 3;
				for(i=0;i<10;i+=3) {
					if(h2.charAt(i)==h2.charAt(i+3)) {
						if(cnt==0) {
							hcard2 = h2.charAt(i);
							cnt++;
						}
						if(cnt==1) {
							hcard22 = h2.charAt(i);
							break;
						}
					}
				}
			}
		
		//checking for One Pair
		if(rank1==0)
			if(h1.charAt(0)==h1.charAt(3) || h1.charAt(3)==h1.charAt(6) || h1.charAt(6)==h1.charAt(9) || h1.charAt(9)==h1.charAt(12)) {
				rank1 = 2;
				for(i=0;i<10;i+=3) {
					if(h1.charAt(i)==h1.charAt(i+3)) {
						hcard1 = h1.charAt(i);
						break;
					}
				}
			}
				
		if(rank2==0)
			if(h2.charAt(0)==h2.charAt(3) || h2.charAt(3)==h2.charAt(6) || h2.charAt(6)==h2.charAt(9) || h2.charAt(9)==h2.charAt(12)) {
				rank2 = 2;	
				for(i=0;i<10;i+=3) {
					if(h2.charAt(i)==h2.charAt(i+3)) {
						hcard2 = h2.charAt(i);
						break;
					}
				}
			}
			
		if(rank1>rank2) {
			System.out.println(h1+ " <-> " + h2 +" = " + rank1+" "+rank2+" - 1 wins");
			return 1;
		}
		
		if(rank1==rank2 && (rank1==8 ||rank1==4 ||rank1==2)) {
			System.out.print(h1+ " <-> " + h2 +" = " + rank1+" "+rank2+" ("+hcard1+", "+hcard2+")");
			if(cardValue(hcard1) > cardValue(hcard2)) {
				System.out.println(" - 1 wins");
				return 1;
			} else if(cardValue(hcard1) < cardValue(hcard2)) {
				System.out.println();
				return 0;
			}
			System.out.println();
		}
		
		if(rank1==rank2 && (rank1==3 || rank1==7)) {
			System.out.print(h1+ " <-> " + h2 +" = " + rank1+" "+rank2+" ("+hcard1+", "+hcard2+")"+" ("+hcard11+", "+hcard22+")");
			if(cardValue(hcard1) > cardValue(hcard2)) {
				System.out.println(" - 1 wins"); 
				return 1;
			} else if(cardValue(hcard1) < cardValue(hcard2)){
				System.out.println();
				return 0;
			} 
			else if(cardValue(hcard11) > cardValue(hcard22)) {
				System.out.println(" - 1 wins");
				return 1;	
			}
			else if(cardValue(hcard11) < cardValue(hcard22)) {
				System.out.println();
				return 0;
			}
			System.out.println();
		}
		
		
		if(rank1==rank2) {
			for(i=0;i<14;i+=3) {
				if(cardValue(h1.charAt(i)) > cardValue(h2.charAt(i))) {
					System.out.println(h1+ " <-> " + h2 +" = " + rank1+" "+rank2+" - 1 wins");
					return 1;
				}
				else if(cardValue(h1.charAt(i)) < cardValue(h2.charAt(i))) {
					System.out.println(h1+ " <-> " + h2 +" = " + rank1+" "+rank2);
					return 0;
				}
				else continue;
			}
		}
		
			
		System.out.println(h1+ " <-> " + h2 +" = " + rank1+" "+rank2);
		return 0;		
	}
	
	public static int suite(String s) {
		if(s.charAt(1)==s.charAt(4) && s.charAt(1)==s.charAt(7) && s.charAt(1)==s.charAt(10) && s.charAt(1)==s.charAt(13)) 
			return 1;
		return 0;
	}
	
	public static String order(String x) {
		StringBuilder s = new StringBuilder(x);
		int i,j;
		char temp;
		for(i=0;i<14;i+=3) {
			for(j=0;j<14-3-i;j+=3) {
				if(cardValue(s.charAt(j)) < cardValue(s.charAt(j+3))) {
					temp = s.charAt(j+3);
					s.setCharAt(j+3,s.charAt(j));
					s.setCharAt(j, temp);
					
					temp = s.charAt(j+4);	//exchange suites of respective classes
					s.setCharAt(j+4,s.charAt(j+1));
					s.setCharAt(j+1, temp);
				}
			}
		}
		return s.toString();
	}
	
	
	public static int cardValue(char c) {
		switch(c) {
			case '2': return 2;
			case '3': return 3;
			case '4': return 4;
			case '5': return 5;
			case '6': return 6;
			case '7': return 7;
			case '8': return 8;
			case '9': return 9;
			case 'T': return 10;
			case 'J': return 11;
			case 'Q': return 12;
			case 'K': return 13;
			case 'A': return 14;
		}
		return 0;
	}
}
	
