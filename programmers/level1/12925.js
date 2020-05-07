// 문자열을 정수로 바꾸기


// 1
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


// 2
function solution(s) {
    return s*1;
}
