// x만큼 간격이 있는 n개의 숫자

const solution = (x, n) => {
    const answer = []
    for (let i=1; i<=n; i++){
        answer.push(x*i)
    }
    return answer   
}
