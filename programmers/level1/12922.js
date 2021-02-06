// 수박수박수박수박수박수?

function solution(n) {
    var answer = '';
    for(var i=0; i<n; i++){
        answer += i%2==0? "수" : "박";
    }
    return answer;
}

// 2021.02.05
const solution = (n) => {
    const watermelon = "수박";
    let answer = "";
    for (let i = 1; i <= Math.floor(n/2); i++){
        answer += watermelon;
    }
    if (n%2 !== 0){
        answer += "수"
    }
    return answer;
}
