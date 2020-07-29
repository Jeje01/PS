// 돌 게임 3

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      boolean[] dp = new boolean[n+1];
      boolean[] first = {false, true, false, true, true};
      for(int i=0; i<n+1; i++) {
         if(i<first.length)
            dp[i] = first[i];
         else {
            dp[i] = !(dp[i-1] & dp[i-3] & dp[i-4]);
         }
      }
      if(dp[n])
         System.out.println("SK");
      else
         System.out.println("CY");   
   }
}
