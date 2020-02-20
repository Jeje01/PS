import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0 && b==0 && c==0)
				break;
			int max = Math.max(Math.max(a, b), c);
			if(max>=a+b+c-max) {
				list.add("Invalid");
			}
			else if(a==b && b==c) {
				list.add("Equilateral");
			}
			else if(a==b || b==c || c==a) {
				list.add("Isosceles");
			}
			else {
				list.add("Scalene");
			}	
		}
		for(String s: list) {
			System.out.println(s);
		}
	}
}
