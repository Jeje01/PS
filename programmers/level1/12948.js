// 핸드폰 번호 가리기

function solution(phone_number) {
    var str=''
    for(var i=0; i<phone_number.length; i++)
        if(i<phone_number.length-4) str+="*"
        else str+=phone_number[i]
    return str
}
