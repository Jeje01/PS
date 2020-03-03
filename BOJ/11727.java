import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n >= 2) dp[2] = 3;
        for (i = 3; i < n+1; i++) {
            dp[i] = dp[i - 1] % 10007 + 2 * dp[i - 2] % 10007;
        }
        System.out.println(dp[n] % 10007);
    }
}
