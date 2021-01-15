// 최대공약수와 최소공배수

const solution = (n, m) => {
    const answer = []
    for(let i=Math.min(n, m); i>0; i—){
        if(n%i==0 && m%i==0){
            answer.push(i)
            break
        } 
    }
    answer.push(n/answer[0]*m)
    return answer
}
