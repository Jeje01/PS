import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int i;
		int cnt1=0, cnt2=0;
		for(i=0; i<s.length()-2; i++) {
			if((s.substring(i, i+3)).equals("JOI"))
				cnt1++;
			else if((s.substring(i, i+3)).equals("IOI"))
				cnt2++;
		}
		System.out.println(cnt1+"\n"+cnt2);
	}
}
