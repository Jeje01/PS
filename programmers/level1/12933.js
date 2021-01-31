// 정수 내림차순으로 배치하기

// 2020.05.13
function solution(n) {
    var answer = n.toString().split("").sort().reverse().join("")*1;
    return answer;
}

// 2021.01.31
const solution = (n) => {
    return parseInt(n.toString().split("").sort().reverse().join(""))
}
