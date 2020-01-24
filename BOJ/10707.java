import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		int x, y;
		x = a*p;
		if(p<=c)
			y = b;
		else
			y = b+(p-c)*d;
		System.out.println(Math.min(x,  y));
	}	
}
