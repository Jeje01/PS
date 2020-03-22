//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int i, j, max=0;
        for(i=1; i<n+1; i++)
            arr[i] = sc.nextInt();
        dp[1] = arr[1];
        for(i=2; i<n+1; i++){
            dp[i] = arr[i];
            for(j=1; j<i; j++){
                if(arr[j]<arr[i] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j]+arr[i];
                }
            }
        }
        for(i=1; i<n+1; i++)
            if(dp[i]>max) max = dp[i];
        System.out.println(max);
    }
}
