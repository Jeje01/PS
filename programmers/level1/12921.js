// 소수 찾기

function solution(n) {
    let arr = [], answer = 0;
    for(let i=0; i<n+1; i++) arr.push(0)
    for(let i=2; i<n+1; i++){
        if(arr[i]==1) continue;
        for(let j = i*2; j<n+1; j+=i){
             arr[j] = 1; 
        }
    }
    arr.forEach(a => {if(a==0) answer++})
    return answer-2
}
