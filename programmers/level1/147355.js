// 크기가 작은 부분문자열

const solution = (t, p) => {
    const len = t.length
    const pLen = p.length
    let answer = 0
    for (let i = 0; i < len - pLen + 1; i++) {
        const num = Number(t.slice(i, i+pLen))
        answer += num <= Number(p) ? 1 : 0
    }
    return answer
}
