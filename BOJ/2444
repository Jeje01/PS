import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i, j;
		for(i = 0; i<n; i++) {
			for(j = 0; j<n-i-1; j++)
				System.out.print(" ");
			for(j = 0; j<2*(i+1)-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(i = 0; i<n-1; i++) {
			for(j = 0; j<i+1; j++)
				System.out.print(" ");
			for(j = 0; j<2*(n-i-1)-1; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
