// 종이접기

function solution(n) {
    var answer = [0], arr=[0]
    for(var i=1; i<n; i++){
        answer.push(0)
        answer = answer.concat(arr.reverse().map(a => 1-a))
        arr = answer.slice()
    }
    return answer
}
