// 시저 암호

function solution(s, n) {
    s = s.split("").map(a => {
        if(a==' ') return ' ';
        var tmp = a.charCodeAt(0);
        if(tmp>=65 && tmp<=90){
            tmp+=n;
            if(tmp>90) tmp-=26;
        }else if(tmp>=97 && tmp<=122){
            tmp+=n;
            if(tmp>122) tmp-=26;
        }
        return String.fromCharCode(tmp);
    })
    return s.join("");
}
