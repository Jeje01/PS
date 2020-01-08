import java.util.Scanner;

public class Main {
	public static void lcm(int a, int b) {
		int gcd = 1;
		for(int i = 2; i <= Math.min(a, b); i++) {
			if((a%i==0)&&(b%i==0)) {
				gcd=i;
			}
		}
		System.out.println(gcd*(a/gcd)*(b/gcd));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, j;
		int[][] g = new int[t][2];
		for(i = 0; i<t; i++) {
			for(j = 0; j<2; j++) {
				g[i][j] = sc.nextInt();
			}
		}
		for(i = 0; i < t; i++)
			lcm(g[i][0], g[i][1]);
	}
}
