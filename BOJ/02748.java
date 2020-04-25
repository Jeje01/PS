import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        long[] dp = new long[n+1];
        for(i=0; i<n+1; i++){
            if(i<2) dp[i] = i;
            else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }
}
