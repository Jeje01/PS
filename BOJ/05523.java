import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a, b;
		int ai=0, bi=0;
		int i;
		for(i=0; i<n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a>b) ai++;
			else if (a<b) bi++;
		}
		System.out.println(ai+" "+bi);
	}	
}
