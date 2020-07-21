// RGB거리

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer;
		int[][] arr = new int[n][3];
		int[][] dp = new int[n][3];
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		dp[0] = arr[0];
		for(int i=1; i<n; i++) {
			dp[i][0]= arr[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1]= arr[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2]= arr[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
		}
		answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(answer);
	
	}

}