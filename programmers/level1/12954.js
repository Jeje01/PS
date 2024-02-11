// x만큼 간격이 있는 n개의 숫자

const solution = (x, n) => {
    const answer = []
    for (let i=1; i<=n; i++){
        answer.push(x*i)
    }
    return answer   
}

// 2021.03.06
const solution = (x, n) => {
    const answer = []
    for (let i = 1; i <= n; i++) {
        answer.push(x*i)
    }
    return answer
}

// 2024.02.11
const solution = (x, n) => {
    const answer = [x]
    for (let i = 1; i < n; i++) {
        answer.push(answer[i - 1] + x)
    }
    return answer
}
