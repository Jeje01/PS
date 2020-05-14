// 숫자의 표현

function solution(n) {
    var answer = 1;
    if(n%2!=0) answer++;
    for(var i=3; i<n; i++)
        if(n%i==0 && i%2!=0) answer++;
    return answer;
}
