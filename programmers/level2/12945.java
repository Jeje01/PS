//피보나치 수

class Solution {    
  public int solution(int n) {
      int i;
      int[] dp = new int[n+1];
      for(i= 0; i<n+1; i++){
          if(i<2) dp[i]=i;
          else{
              dp[i]=dp[i-1]%1234567+dp[i-2]%1234567;
          }
      }
      return dp[n]%1234567;     
  }
}
