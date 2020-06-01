// 가장 큰 수 - 정렬

function solution(numbers) {
    var answer = ''
    numbers = numbers.map(a => a+"")
    numbers.sort((a, b) => (a+b)-(b+a)).reverse()
    for(var a of numbers)
        answer+=a
    if(answer*1==0) return "0"
    return answer;
}
