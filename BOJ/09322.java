// 철벽 보안 알고리즘

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int n = sc.nextInt();
			String[] keyOne = new String[n];
			String[] keyTwo = new String[n];
			String[] encrypted = new String[n];
			String[] answer = new String[n];
			for(int i=0; i<n; i++)
				keyOne[i] = sc.next();
			for(int i=0; i<n; i++)
				keyTwo[i] = sc.next();			
			for(int i=0; i<n; i++)
				encrypted[i] = sc.next();
			int[] orders = new int[n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(keyTwo[i].equals(keyOne[j])) {
						orders[i] = j;
						break;
					}
				}
			}
			for(int i=0; i<n; i++) {
				answer[orders[i]] = encrypted[i];
			}
			for(String a: answer)
				System.out.print(a+" ");
		}
		
	}
}
