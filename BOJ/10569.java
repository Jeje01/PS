import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int i, v, e;
		int[] ans = new int[t];
		for(i=0; i<t; i++) {
			v = sc.nextInt();
			e = sc.nextInt();
			ans[i] = 2-v+e;
		}
		for(i=0; i<t; i++)
			System.out.println(ans[i]);
	}	
}
