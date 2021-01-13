// 2016년

// 1 - 2020.05.06
function solution(a, b) {
    var answer = '';
    var days = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];
    var mon = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var sum = a!=1 ? mon.slice(0, a-1).reduce((ac, cur) => ac+cur) : 0;
    answer = days[(sum+b-1)%7];
    return answer;
}

// 2 - 2021.01.13
const solution = (a, b) => {
    const days = ["SUN", "MON", "TUE", "WED", "THU", "FRI" ,"SAT"]
    const month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30]
    let total = 0
    for(let i = 0; i < a - 1; i++) {
        total += month[i]
    }
    return days[(total + b + 4) % 7]
}
