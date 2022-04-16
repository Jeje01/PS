// 나머지가 1이 되는 수 찾기

const solution = (n) => {
    let answer = 2
    for (answer; answer < n; answer++) {
        if (n % answer === 1) {
            break
        }
    }
    return answer
}
