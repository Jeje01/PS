//Dynamic programming

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int i;
        dp[0]= 0;
        for(i=1; i<n; i++){
            dp[i]=dp[i-1]+1;
            if((i+1)%2==0) dp[i]=Math.min(dp[i], dp[(i+1)/2-1]+1);
            if((i+1)%3==0) dp[i]=Math.min(dp[i], dp[(i+1)/3-1]+1);
        }
        System.out.println(dp[n-1]);
    }
}
