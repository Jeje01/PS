import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i;
		String[] str = new String[n];
		for(i=0; i<n; i++) {
			str[i]=sc.next();
		}
		for(i=0; i<n; i++) {
			System.out.println(str[i].toLowerCase());
		}
	}	
}
