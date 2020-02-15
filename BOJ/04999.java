import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String in = sc.next();
		String out = sc.next();
		if(in.length()>=out.length())
			System.out.println("go");
		else
			System.out.println("no");
	}
}
