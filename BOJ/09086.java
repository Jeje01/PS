import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		char a, b;
		String[] s = new String[n];
		for(i=0; i<n; i++) {
			s[i]=sc.next();
		}
		for(i=0; i<n; i++) {
			a = s[i].charAt(0);
			b = s[i].charAt(s[i].length()-1);
			System.out.print(a);
			System.out.println(b);
		}
	}
}
