//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int i, max=-1001;
        for(i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        dp[1] = arr[1];
        for(i=2; i<n+1; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
        }
        for(i=1; i<n+1; i++)
            max = max<dp[i]? dp[i] : max;
        System.out.println(max);
    }
}
