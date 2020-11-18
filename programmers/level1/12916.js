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

// 20201117
const solution = (s) => {
    s = s.toLowerCase()
    let cntp = 0, cnty = 0
    s.split("").forEach(a => {
        if(a=='p') cntp ++
        if(a=='y') cnty ++
    })
    return cntp == cnty
}
