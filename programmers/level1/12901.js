// 2016년

function solution(a, b) {
    var answer = '';
    var days = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];
    var mon = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    var sum = a!=1 ? mon.slice(0, a-1).reduce((ac, cur) => ac+cur) : 0;
    answer = days[(sum+b-1)%7];
    return answer;
}
