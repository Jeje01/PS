// 올바른 괄호

function solution(s){
    var answer = true, cnt=0;
    s.split("").forEach(a => {
        if(a=="("){
            cnt++;
        } else{
            if(cnt>0) cnt--;
            else{
                answer=false;
            }
        }
    })
    if(cnt!=0) return false;
    return answer;
}
