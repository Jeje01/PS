//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int i, cnt=1;
        for(i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        dp[1] = arr[1];
        for(i=2; i<n+1; i++){
            if(i==2) dp[i] = arr[i] + arr[i-1];
            else {
                dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]), dp[i-3]+arr[i-1]+arr[i] );
            }
        }
        System.out.println(dp[n]);
    }
}
