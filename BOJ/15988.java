// 1, 2, 3 더하기 3 - DP

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[1000001];
		int[] nums = new int[T];
		int mod = 1000000009;
		for(int i=0; i<T; i++) {
			nums[i] = sc.nextInt();
		}
		for(int i=0; i<T; i++) {
			dp[1] = 1; dp[2] = 2; dp[3] = 4;
			for(int j=4; j<nums[i]+1; j++) {
				dp[j] = ((dp[j-1]+dp[j-2])%mod+dp[j-3])%mod;
			}
			System.out.println(dp[nums[i]]);
		}
	}

}
