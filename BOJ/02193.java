import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        long[] dp = new long[n+1];
        int i;
        for(i=1; i<n+1; i++){
            if(i<3) dp[i] = 1;
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }
}
