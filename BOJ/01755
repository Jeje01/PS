import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static String intoStr(int x) {
		String answer="";
		if(x<10) {
			switch(x) {
			case 0:
				answer="zero";
				break;
			case 1:
				answer="one";
				break;
			case 2:
				answer="two";
				break;				
			case 3:
				answer="three";
				break;		
			case 4:
				answer="four";
				break;		
			case 5:
				answer="five";
				break;		
			case 6:
				answer="six";
				break;		
			case 7:
				answer="seven";
				break;		
			case 8:
				answer="eight";
				break;		
			case 9:
				answer="nine";
				break;		
			}
		}
		else {
			answer=intoStr(x/10)+" "+intoStr(x%10);
		}
		return answer;
	}
	public static int intoInt(String s) {
		String[] str=s.split(" ");
		int answer=0;
		if(str.length==1) {
			switch(s) {
			case "zero":
				answer=0;
				break;
			case "one":
				answer=1;
				break;
			case "two":
				answer=2;
				break;				
			case "three":
				answer=3;
				break;		
			case "four":
				answer=4;
				break;		
			case "five":
				answer=5;
				break;		
			case "six":
				answer=6;
				break;		
			case "seven":
				answer=7;
				break;		
			case "eight":
				answer=8;
				break;		
			case "nine":
				answer=9;
				break;		
			}
		}
		else {
			answer=intoInt(str[0])*10+intoInt(str[1]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		String[] str = new String[n-m+1];
		int i;
		for(i=m; i<=n; i++) {
			str[i-m]=intoStr(i);
		}
		Arrays.sort(str);
		for(i=0; i<n-m+1; i++) {
			System.out.print(intoInt(str[i])+" ");
			if((i+1)%10==0)
				System.out.println();
		}			
	}
}
