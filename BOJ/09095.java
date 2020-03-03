//DP
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, SIZE = 11;
        int[] answer = new int[t];
        int[] dp = new int[SIZE];
        dp[1]=1; dp[2]=2; dp[3]=4;
        for(i=4; i<SIZE; i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(i=0; i<t; i++){
            answer[i] = dp[sc.nextInt()];
        }
        for(i=0; i<t; i++)
            System.out.println(answer[i]);
    }
}
