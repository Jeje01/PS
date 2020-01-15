import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i;
		int a=100, b=100;
		int m, n;
		for(i=0; i<t; i++) {
			m=sc.nextInt();
			n=sc.nextInt();
			if(m>n) b-=m;
			else if(m<n) a-=n;
		}
		System.out.println(a);
		System.out.println(b);
	}
}
