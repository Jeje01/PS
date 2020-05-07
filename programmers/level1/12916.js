// 문자열 내 p와 y의 개수

function solution(s){
    var i, p=0, y=0;
    s = s.toLowerCase();
    for(i=0; i<s.length; i++){
        if(s[i]=='p')
            p++;
        else if(s[i]=='y')
            y++;
    }
    return p==y;
}
