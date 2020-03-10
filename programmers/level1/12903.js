//가운데 글자 가져오기

function solution(s) {
    var answer = '';
    var len = s.length;
    if(len%2!=0){
        answer = s.charAt((len-1)/2);
    }
    else{
        answer = s.substring(len/2-1, len/2+1);
    }
    return answer;
}
