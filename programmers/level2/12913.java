// 땅따먹기

class Solution {
    int solution(int[][] land) {
        int answer = 0, i, j, len = land.length;
        int[][] dp = new int[len][4];
        for(i=0; i<len; i++){
            if(i==0)
                for(j=0; j<4; j++)
                    dp[i][j] = land[i][j];
            else{
                dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3])+land[i][0];
                dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3])+land[i][1];
                dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3])+land[i][2];
                dp[i][3] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2])+land[i][3];
            }
        }
        answer = Math.max(Math.max(Math.max(dp[len-1][0], dp[len-1][1]), dp[len-1][2]) , dp[len-1][3]);
        return answer;
    }
}
