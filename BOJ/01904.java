//DP
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int i;
        for(i=1; i<n+1; i++){
            if(i<=3) dp[i]=i;
            else
                dp[i]=dp[i-1]%15746+dp[i-2]%15746;
        }
        System.out.println(dp[n]%15746);
    }
}
