//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[][] dp = new int[2][n+1];
        int i, j, max=0;
        for(i=1; i<n+1; i++)
            arr[i] = sc.nextInt();
        for(i=1; i<n+1; i++){
            dp[0][i] = 1;
            if(i!=1) {
                dp[0][i] = 1;
                for(j=1; j<i; j++){
                    if(arr[j] < arr[i] && dp[0][j]>= dp[0][i]){
                        dp[0][i] = dp[0][j]+1;
                    }
                    else if(arr[j] == arr[i]){
                        dp[0][i] = dp[0][j];
                    }
                }
            }
        }
        for(i=n; i>0; i--){
            dp[1][i] = 1;
            if(i!=n){
                for(j=n; i<j; j--){
                    if(arr[i]>arr[j] && dp[1][i] <= dp[1][j]){
                        dp[1][i] = dp[1][j] + 1;
                    }
                    else if(arr[j]==arr[i]) {
                        dp[1][i] = dp[1][j];
                    }
                }
            }
        }
        for(i=1; i<n+1; i++){
            int tmp = dp[0][i]+dp[1][i];
            max = tmp>max ? tmp : max;
        }
        System.out.println(max-1);
    }
}
