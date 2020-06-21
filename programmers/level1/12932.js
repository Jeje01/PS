// 자연수 뒤집어 배열로 만들기

function solution(n) {
    var answer = (n+"").split("").reverse().map(a => a*1)
    return answer;
}
