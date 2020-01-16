import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] sp = str.split(" ");
		int i, answer=0;
		for(i=0; i<sp.length; i++) {
			answer+=Integer.parseInt(sp[i]);
		}
		System.out.println(answer);
	}
}
