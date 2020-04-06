function solution(a, b) {
    var answer = 0;
    if(a==b) return a;
    var max = Math.max(a, b);
    var min = Math.min(a, b);
    for(var i=min; i<=max; i++)
        answer +=i;
    return answer;
}
