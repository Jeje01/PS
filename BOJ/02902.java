import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split("-");
		String answer = String.valueOf(s[0].charAt(0));
		for(int i = 1; i<s.length; i++) {
			answer += String.valueOf(s[i].charAt(0));
		}
		System.out.println(answer);		
	}
}
