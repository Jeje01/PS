/**
 * 이친수 - S3
 * DP
 * 12,992 kb
 * 80 ms
 * 
 * 6달 전에 풀었었는데 똑같이 틀린 문제
 * 틀릴 이유가 없는데 뭔가 했더니 N이 커지면 long을 써야 됨
 * 
 * (1)에서 if 조건이 없을 경우 N=1일 때 런타임 에러가 발생한다.
 * (1)의 두 줄 대신 (2)를 사용하면 에러날 일이 없다.
 */

// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	
	// 1
	// 10
	// 100, 101 
	// 1000, 1001, 1010
	// 10001, 10000, 10010, 10101, 10100
	// 1, 1, 2, 3, 5, 8, 13, 21
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		long[] dp = new long[N+1];
		dp[1] = 1;
		if(N>=2) dp[2] = 1; // - (1)
		for(int i=1; i<=N; i++) {
            if(i<3){
            	// dp[i] = 1; - (2)
            	continue;
            }else{
    			dp[i] = dp[i-1]+dp[i-2];
            }
		}
        output.append(dp[N]);
		System.out.println(output.toString());
	}
	
}






// 1
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        long[] dp = new long[n+1];
        int i;
        for(i=1; i<n+1; i++){
            if(i<3) dp[i] = 1;
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }
}
