/**
 * 상자넣기 - S2
 * DP, LIS
 * 13,380 kb
 * 112 ms
 * 
 * 단순 LIS 문제
 * 
 * dp[j]>=dp[i]일 때 dp[j]+1 값을 대입해야 하지만 조건을 반대로 써도 통과됨
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int n, arr[], dp[], answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(input.readLine());
		arr = new int[n+1];
		dp = new int[n+1];
		tokens = new StringTokenizer(input.readLine(), " ");
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i] && dp[j]>=dp[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		for(int a: dp) {
			answer = Math.max(answer, a);
		}
		output.append(answer);
		System.out.println(output.toString());
	
	}
}
