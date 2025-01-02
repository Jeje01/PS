// 삼총사

/**
  * 주어진 범위와 난이도 고려했을 때 삼중 for문이 빠르게 풀 수 있는 방법이지만 범위가 커지면 개선 필요
**/

// sol.1
const solution = (number) => {
    const len = number.length
    let answer = 0
    for (let i = 0; i < len - 2; i++) {
        const first = number[i]
        for (let j = i + 1; j < len - 1; j++) {
            const second = number[j]
            for (let k = j + 1; k < len; k++) {
                const third = number[k]
                if (first + second + third === 0) answer ++
            }
        }
    }
    
    return answer
}

