// 카펫 - 완전탐색

function solution(brown, yellow) {
    var answer = [];
    for(var i = 1; i<=yellow; i++){
        if(yellow%i==0 && i>=yellow/i)
            if(i*2+yellow/i*2+4==brown){
                answer.push(i+2);
                answer.push(yellow/i+2);
                break;
            }
    }   
    return answer;
}
