//dp

import java.util.Scanner;

public class Main {
    public static int func(int[][] a){
        int len = a[0].length;
        int[][] dp = new int[len+1][2];
        int i, j;
        for(i=1; i<len+1; i++){
            if(i==1){
                dp[i][0] = a[0][i-1];
                dp[i][1] = a[1][i-1];
            }
            else {
                dp[i][0] = Math.max(a[0][i-1] + dp[i-1][1], a[0][i-1] + dp[i-2][1]);
                dp[i][1] = Math.max(a[1][i-1] + dp[i-1][0], a[1][i-1] + dp[i-2][0]);
            }
        }
        return Math.max(dp[len][0], dp[len][1]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i, j, k;
        int[] answer = new int[t];
        for(i=0; i<t; i++){
            int n = sc.nextInt();
            int[][] arr = new int[2][n];
            for(j=0; j<2; j++){
                for(k=0; k<n; k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            answer[i] = func(arr);
        }
        for(i=0; i<t; i++)
            System.out.println(answer[i]);
    }
}
