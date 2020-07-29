// 괄호 변환

function solution(p) {
    // '균형잡힌 괄호 문자열'인지 확인
    const checkBalanced = (str) => {
        let left=0, right=0;
        (str.split("")).forEach(a => {
            if(a=='(') left++;
            else right++;
        })
        if(left==right) return true;
        else return false;
    }
    // '올바른 괄호 문자열'인지 확인
    const checkRight = (str) => {
        let count=0;
        const array = str.split("");
        for(let a of array){
            if(a=='(') count++;
            else{
                if(count>0) count--;
                else{
                    return false;
                } 
            }
        }
        return true;
    }
    let answer = '', left=0, right=0, u='', v='';
    // 1.
    if(checkRight(p)==true || p=='') return p;
    // 2.
    for(let i=2; i<p.length+1; i+=2){
        if(checkBalanced(p.substring(0, i))==true){
            u = p.substring(0, i);
            v = p.substring(i);
            break;
        }
    }
    // 3.
    if(checkRight(u)==true){
        answer+=u;
        answer+=solution(v);
    }else{
        // 4.
        answer= '('+solution(v)+')'+
            u.substring(1, u.length-1).split("").map(a => {
                if(a=='(') return ')';
                else return '(';
            }).join("");
    }
    return answer;
}
