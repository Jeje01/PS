// 기타줄

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int minPackage = Integer.MAX_VALUE;
		int minOne = Integer.MAX_VALUE;
		for(int i=0; i<m; i++) {
			int packagePrice = sc.nextInt();
			int onePrice = sc.nextInt();
			minPackage = minPackage > packagePrice ? packagePrice : minPackage;
			minOne = minOne > onePrice ? onePrice : minOne;
		}
		int answer = Math.min(Math.min(minOne*n, minPackage*(int)Math.ceil((float)n/6)), (minPackage*(n/6)+minOne*(n%6)));
		System.out.println(answer);
	}
}
