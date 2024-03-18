// 사칙연산 - DP

/*
  24.03.18 (월)
  첫 4레벨

  바로 풀이 봄.
  Number.MAX_INTEGER을 초기화할 때 사용하니 몇 개가 틀려 Infinity를 사용하니 됨
  인덱스가 헷갈림
  a~b의 조합으로 계산하는데 2개 조합일 때부터 계산해서 이걸 조합이 커질 때 이용해야 함
*/
const solution = (arr) => {
    const len = (arr.length + 1)/2
    const maxDp = Array.from(Array(len), () => new Array(len).fill(-Infinity))
    const minDp = Array.from(Array(len), () => new Array(len).fill(Infinity))
    let gap = 1
    
    for (let i = 0; i < len; i++) {
        maxDp[i][i] = minDp[i][i] = Number(arr[2 * i])
    }
    
    while (gap < len) {
        for (let i = 0; i < len - 1; i++) {
            let j = i + gap
            if (j >= len) continue
            for (let k = i; k < j; k++) {
                const char = arr[2*k + 1]
                if (char === "+") {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k+1][j])
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k+1][j])
                } else {
                    maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k+1][j])
                    minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k+1][j])
                }
            }
        }
        gap++
    }
    
    return maxDp[0][len - 1]
}
