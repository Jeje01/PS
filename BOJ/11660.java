/**
 * 구간 합 구하기 5 - S1
 * DP
 * 132,644 kb
 * 748 ms
 *
 * 각 위치에서 위로 왼쪽으로의 범위의 모든 수를 더한 값을 저장
 */   
   
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;
   static int N, M, x1, y1, x2, y2, dp[][];
   
   public static void main(String[] args) throws IOException {
      tokens = new StringTokenizer(input.readLine(), " ");
      N = Integer.parseInt(tokens.nextToken());
      M = Integer.parseInt(tokens.nextToken());
      dp = new int[N][N];
      for(int i=0; i<N; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");      
         int sum=0;
         for(int j=0; j<N; j++) {
            int tmp = Integer.parseInt(tokens.nextToken());
            sum+=tmp;
            if(i==0) dp[i][j] = sum;
            else {
               dp[i][j]=dp[i-1][j]+sum;
            }
         }
      }

      for(int i=0; i<M; i++) {
         tokens = new StringTokenizer(input.readLine(), " ");
         int[] arr = new int[4];
         for(int j=0; j<4; j++) {
            arr[j] = Integer.parseInt(tokens.nextToken())-1;
         }
         int total = dp[arr[2]][arr[3]];
         if(arr[1]>0) {
            total-=dp[arr[2]][arr[1]-1];
            if(arr[0]>0) {
               total+=dp[arr[0]-1][arr[1]-1];
            }
         }
         if(arr[0]>0) {
            total-=dp[arr[0]-1][arr[3]];
         }

         output.append(total).append("\n");
      }
      System.out.println(output.toString());
   }
}
