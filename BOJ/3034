import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		String[] s = new String[n];
		int i, x;
		for(i=0; i<n; i++) {
			x = sc.nextInt();
			if(x<=Math.sqrt(w*w+h*h))
				s[i] = "DA";
			else
				s[i] = "NE";
		}
		for(i=0; i<n; i++)
			System.out.println(s[i]);
	}
}
