/**
 * 정수 삼각형
 * DP
 * 25,300 kb
 * 240 ms
 */
 
 import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int n, index, answer;
    static int[] arr, dp;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(input.readLine());
        int len = n*(n+1)/2+1;
        arr = new int[len];
        dp = new int[len];
        
        // 입력 받기
        index=1;
        arr[1] = Integer.parseInt(input.readLine());
        for(int i=2; i<=n; i++) {
            tokens = new StringTokenizer(input.readLine(), " ");
            for(int j=1; j<=i; j++) {
                index++;
                arr[index] = Integer.parseInt(tokens.nextToken());
            }
        }

        dp[1] = arr[1];
        index=0;
        for(int i=1; i<=n-1; i++) {
            for(int j=1; j<=i; j++) {
                index++;
                dp[index+i] = Math.max(dp[index+i], arr[index+i]+dp[index]);
                dp[index+i+1] = Math.max(dp[index+i+1], arr[index+i+1]+dp[index]);
            }
        }
        for(int i=dp.length-n; i<dp.length; i++) {
            answer = dp[i]>answer? dp[i]: answer;
        }
        System.out.println(answer);
        
        
    }

}
