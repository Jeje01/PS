/**
 * 쉬운 계단 수 - S1
 * DP
 * 130,16 kb
 * 84 ms
 * 
 * 예전에도 풀이가 떠오르지 않아 찾아서 풀었었는데 이번에도 떠오르지 않았음
 * 완벽하게 이해하지 못하고 풀었었음
 * 
 * * 풀이
 * dp[N][i]은 첫자리가 i이고 숫자의 길이가 N인 수의 개수
 * 
 * * 효율성 / 메모리
 * dp[N]과 dp[N-1]만 사용하기 때문에 dp[N+1] 대신 dp[2]만 사용해도 충분함
 * 하지만, dp[1]을 dp[0]으로 옮겨주는 과정이 필요함
 * N의 범위가 최대 100이라서 메모리에 큰 변화가 없으며, 효율성도 비슷함
 * 
 * * 주의
 * MOD를 필요한 곳에 해줘야 오버플로우 발생 x
 * 오버플로우 발생시 WA로 나오기 때문에 미리 체크하지 않으면 찾기 힘들 수 있음
 */

// 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output =new StringBuilder();
	static StringTokenizer tokens;
	static int N, MOD = 1000000000;
	static long answer;
	static int dp[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		dp = new int[2][10];
		Arrays.fill(dp[1], 1);
		for(int n=2; n<N+1; n++) {
			for(int i=0; i<10; i++) {
				dp[0][i] = dp[1][i];
			}
			for(int i=0; i<10; i++) {
				if(i==0) {
					dp[1][i] = dp[0][1];
				}else if(i==9) {
					dp[1][i] = dp[0][8];
				}else {
					dp[1][i] = (dp[0][i-1]+dp[0][i+1])%MOD;
				}
			}
			
		}
		for(int i=1; i<10; i++) {
			answer = (answer+dp[1][i])%MOD;
		}
		
		output.append(answer);
		System.out.println(output.toString());
	}
}




// 1

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        int i, j, mod = 1000000000, sum=0;
        for(i=1; i<10; i++){
            dp[1][i] = 1;
        }
        for(i=2; i<n+1; i++){
            for(j=0; j<10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1];
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][8];
                }
                else{
                    dp[i][j] = (dp[i-1][j-1]%mod+ dp[i-1][j+1]%mod)%mod;
                }
            }
        }
        for(i=0; i<10; i++){
            sum = (sum+dp[n][i])%mod;
        }
        System.out.println(sum);
    }
}
