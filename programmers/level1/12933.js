// 정수 내림차순으로 배치하기

function solution(n) {
    var answer = n.toString().split("").sort().reverse().join("")*1;
    return answer;
}
