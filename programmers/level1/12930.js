// 이상한 문자 만들기

function solution(s) {
    var answer="";
    var sp = s.split(" ");
    for(var a of sp){
        for(var i=0; i<a.length; i++){
            if(i%2==0){
                answer+=a[i].toUpperCase();
            } else{
                answer+=a[i].toLowerCase();
            }
        }
        answer+=" ";
    }
    return answer.substring(0, s.length);
}

const solution = (arr) => {
    const answer = [arr[0]];
    for(let i=1; i<arr.length; i++){
        if(arr[i]!=arr[i-1])
            answer.push(arr[i]);
    }
    return answer;
}
