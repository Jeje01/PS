import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int i, j, num=2, sum=0;
        dp[1] = 1;
        for(i=2; i<n+1; i++) {
            dp[i] = i;
            for(j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        System.out.println(dp[n]);
    }
}
