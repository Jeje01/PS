// 예산 - Binary Search

function solution(budgets, M) {
    var answer = 0, sum, left=1, right=M, i=0, arr=[]
    var max = Math.max.apply(Math, budgets)
    sum = budgets.reduce((a, c)=> a+c)
    if(sum<=M) return max
    while(true){
        answer = Math.ceil((left+right)/2)
        sum=0
        budgets.forEach(a =>{
            if(a<answer) sum+=a
            else sum+=answer
        })
        arr.push({"dif":M-sum, "mid":answer})
        if(sum<=M)  left = answer+1
        else right = answer-1
        if(i!=0)
            if(arr[i]["mid"]==arr[i-1]["mid"]) break
        i++
    }
    for(var j=i; j>=0; j--)
        if(arr[j].dif>=0)
            return arr[j].mid
}
