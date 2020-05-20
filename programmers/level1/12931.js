// 자릿수 더하기

function solution(n)
{
    var answer = 0;
    for(var a of (n+"")){
        answer+=a*1;
    }
    return answer;
}
