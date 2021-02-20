// 문자열 다루기 기본

function solution(s) {
    s = s.split("");
    if(s.length!=4 && s.length!=6) return false;
    for(var i of s){
        if(!(i*1>=0 && i*1<=9)){
            return false;
        }
    }
    return true;
}

// 2021.02.20
const solution = (s) => {
    s = s.split("");
    let answer = s.length === 4 || s.length === 6;
    s.forEach((num) => {
        if (isNaN(num)) {
            answer = false;
        }
    })
    return answer;
}
