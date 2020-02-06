import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long answer;
		String a = sc.next();
		a += sc.next();
		String c = sc.next();
		c += sc.next();
		answer=Long.parseLong(a)+Long.parseLong(c);
		System.out.println(answer);
	}	
}
