// 예산

function solution(d, budget) {
    var answer = 0;
    d.sort((a,b) => a-b);
    for(var i=0; i<d.length; i++){
        if(budget-d[i]>=0){
            budget-=d[i];
            answer++;
        }else break;
    }
    return answer;
}
