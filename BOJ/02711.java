import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] ans = new String[t];
		int i, j;
		for(i=0; i<t; i++) {
			int pos = sc.nextInt();
			String s = sc.next();
			ans[i]="";
			for(j=0; j<s.length(); j++) {
				if(j!=pos-1)
					ans[i]+=s.charAt(j);
			}
		}
		for(i=0; i<t; i++) {
			System.out.println(ans[i]);
		}
	}
}
