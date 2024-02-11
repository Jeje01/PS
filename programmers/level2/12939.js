// 최댓값과 최솟값

// 20.06.15
function solution(s) {
    var numbers = s.split(" ").map(a => a*1).sort((a, b) => a-b)
    return numbers[0]+" "+numbers[numbers.length-1]
}

// 24.02.11
const solution = (s) => {
    const numbers = s.split(" ")
    const max = Math.max(...numbers)
    const min = Math.min(...numbers)
    return `${min} ${max}`
}
