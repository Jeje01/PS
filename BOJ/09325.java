import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int s, p, q, sum, n;
		int[] ans = new int[num];
		for(int i = 0; i<num; i++) {
			sum = sc.nextInt();
			n = sc.nextInt();
			for(int j = 0; j<n; j++) {
				p = sc.nextInt();
				q = sc.nextInt();
				sum += p*q;
			}
			ans[i] = sum;
		}
		for(int i = 0; i<num; i++)
			System.out.println(ans[i]);
		}
}
