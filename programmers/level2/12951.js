// JadenCase 문자열 만들기

function solution(s) {
    var answer = '';
    answer = s.toLowerCase().split(" ").map(a => {
        if(a == "") return "";
        else{
            var num = a.charCodeAt(0);
            var tmp = num>=97 && num<=122 ? a[0].toUpperCase() : a[0];
            tmp+=a.substring(1);
            return tmp;
        }
    });
    return answer.join(" ");
}
