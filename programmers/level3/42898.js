/*
  등굣길 - DP

  24.03.17 (일)
  - 인덱스 주의
  
  처음에 DFS로 풀었는데 우수수 틀리고 시간초과 남 
  => 좌표가 반대로라서 전체 배열의 인덱스는 바꿔줬는데 puddles의 배열의 인덱스를 바꿔주지 않음

  최단경로이기 때문에 왼쪽이나 위쪽으로 갈 일은 없어서 visited를 관리하지 않아도 되고 오히려 관리하면 에러남
  각 경로가 동일한 곳을 지날 수 있어야 하기 때문임

  조건이 간단해 생각보다 엄청 간단한 DP로 풀 수 있음
*/

const solution = (m, n, puddles) => {
    // n, m
    const MOD = 1_000_000_007
    const dp = Array.from({ length: n + 1 }, () => new Array(m + 1).fill(0))
    
    dp[1][1] = 1
    
    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (i == 1 && j == 1) continue
            if (puddles.some(([x, y]) => y === i && x === j)) {
                dp[i][j] = 0
            } else {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD
            }
        }
    }

    return dp[n][m]
}
