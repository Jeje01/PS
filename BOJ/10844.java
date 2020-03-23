import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[n+1][10];
        int i, j, mod = 1000000000, sum=0;
        for(i=1; i<10; i++){
            dp[1][i] = 1;
        }
        for(i=2; i<n+1; i++){
            for(j=0; j<10; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1];
                }
                else if(j==9){
                    dp[i][j] = dp[i-1][8];
                }
                else{
                    dp[i][j] = (dp[i-1][j-1]%mod+ dp[i-1][j+1]%mod)%mod;
                }
            }
        }
        for(i=0; i<10; i++){
            sum = (sum+dp[n][i])%mod;
        }
        System.out.println(sum);
    }
}
