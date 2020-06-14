// 최댓값과 최솟값

function solution(s) {
    var numbers = s.split(" ").map(a => a*1).sort((a, b) => a-b)
    return numbers[0]+" "+numbers[numbers.length-1]
}
