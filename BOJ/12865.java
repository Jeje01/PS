/**
 * 평범한 배낭 - G5
 * DP, Knapsack
 * 16,992 kb
 * 172 ms
 * 
 * 물건 {1}, {1, 2}, {1, 2, 3} 을 담았을 때의 최대 가치를 각 열에, 0~(제한 무게)마다 저장
 * 모든 열에 dp를 둬도 되지만 바로 위 열만 필요하기 때문에 2열만 두면 메모리가 절약됨
 * 두번째 열은 새로운 값으로 덮어지기 때문에 0으로 바꿀 필요 없음
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, K, arr[][], answer, all, dp[][];
	
	public static void main(String[] args) throws IOException {
		tokens = new StringTokenizer(input.readLine(), " ");
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		arr = new int[N][2];
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(input.readLine(), " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		dp = new int[2][K+1];
		for(int i=arr[0][0]; i<=K; i++) {
			dp[1][i] = arr[0][1];
		}

		for(int n=1; n<N; n++) {
			for(int i=0; i<=K; i++) {
				dp[0][i] = dp[1][i];
			}
			for(int i=0; i<=K; i++) {
				if(i-arr[n][0]>=0) {
					dp[1][i] = Math.max(dp[1][i], dp[0][i-arr[n][0]]+arr[n][1]);										
				}
			}
		}
		output.append(dp[1][K]);
		System.out.println(output.toString());
	}
}
