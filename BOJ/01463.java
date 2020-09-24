/**
 * 2
 * 1로 만들기 - S3
 * DP
 * 16,984 kb
 * 100 ms
 * 
 * 6달 전에 풀었던 문제인데 풀고 나서 보니 풀이가 거의 똑같았다!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		dp = new int[N+1];
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1]+1;
			if(i%2==0) {
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
			if(i%3==0) {
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
		}
		output.append(dp[N]);
		System.out.println(output.toString());
	}
}



// 1

//Dynamic programming

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int i;
        dp[0]= 0;
        for(i=1; i<n; i++){
            dp[i]=dp[i-1]+1;
            if((i+1)%2==0) dp[i]=Math.min(dp[i], dp[(i+1)/2-1]+1);
            if((i+1)%3==0) dp[i]=Math.min(dp[i], dp[(i+1)/3-1]+1);
        }
        System.out.println(dp[n-1]);
    }
}
