// 수들의 합 5

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer=1;
		for(int i=2; i<n/2; i++) {
			if(i%2==0) {
				if((n-i/2)%i==0) {
					if((n-i/2)/i<i/2) break;
					answer++;
				}
			}else {
				if(n%i==0) {
					if(n/i<=i/2) break;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
