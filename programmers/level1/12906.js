// 같은 숫자는 싫어

function solution(s) {
    var answer = 0;
    if(s[0]=="-"){
        answer = (-1)*parseInt(s.substring(1));
    }else if(s[0]=="+"){
        answer = parseInt(s.substring(1));
    }else{
        answer = parseInt(s);
    }
    return answer;
}
