/**
 * 숨바꼭질
 * DP
 * 14,180 kb
 * 108 ms
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
    static int N, K, answer;
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine(), " ");
        N = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());
        if(N==K) {
            answer = 0;
        }else if(K<N) {
            answer = N-K;
        }else if(N<K) {
            dp = new int[200001];
            Arrays.fill(dp, 100001);
            dp[N] = 0;
            for(int i=N-1; i>=0; i--) {
                dp[i] = dp[i+1]+1;
                if(i*2<dp.length) {
                    dp[i*2] = Math.min(dp[i*2], dp[i]+1);
                }
            }
            for(int i=N; i<dp.length; i++) {
                if(i!=N) {
                    if(i-1>=0) {
                        dp[i] = Math.min(dp[i], dp[i-1]+1);
                    }
                        
                    if(i+1<dp.length) {
                        dp[i] = Math.min(dp[i], dp[i+1]+1);
                    }
                }

                if(i*2<dp.length) {
                    dp[i*2] = Math.min(dp[i]+1, dp[i*2]);
                }

            }
            answer = dp[K];
            
        }
        output.append(answer);
        
        System.out.println(output.toString());
    }

}
