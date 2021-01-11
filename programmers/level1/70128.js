// 내적

const solution = (a, b) => {
    let answer = 0
    a.forEach((x, i) => (
        answer += x*b[i]
    ))
    return answer
}
