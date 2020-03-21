//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int i, j, max=0;
        dp[1] = 1;
        for(i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        for(i=2; i<n+1; i++){
            dp[i] = 1;
            for(j=1; j<i; j++){
                if(arr[j] < arr[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }else if(arr[j] == arr[i]){
                    dp[i] = dp[j];
                }
            }
        }
        for(i=1; i<n+1; i++){
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}
