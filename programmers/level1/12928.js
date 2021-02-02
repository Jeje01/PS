// 약수의 합

function solution(n) {
    var answer = 0;
    for(var i=1; i<=n; i++)
        if(n%i==0) answer+=i;
    return answer;
}

// 2021.02.02
const solution = (n) => {
    let answer = 0
    for (let i=1; i<=n; i++) {
        if (n%i === 0) {
            answer += i
        }
    }
    return answer
}
