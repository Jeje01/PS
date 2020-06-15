// 멀리 뛰기 - DP

function solution(n) {
    var answer = 0, dp=[0, 1, 2]
    for(var i=3; i<n+1; i++){
        dp[i] = (dp[i-1]+dp[i-2])%1234567
    }
    return dp[n]
}
