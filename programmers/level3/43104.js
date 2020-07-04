// 타일 장식물 - DP

function solution(N) {
    var dp = [0, 4, 6];
    for(var i=3; i<N+1; i++){
        dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[N];
}
