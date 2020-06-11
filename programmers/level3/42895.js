// N으로 표현

function solution(N, number) {
    if(N==number) return 1
    var check=N.toString(), dp=[0]
    dp.push([N])
    for(var i=2; i<10; i++){
        var tmp = []
        check+=N
        tmp.push(check*1)
        for(var j=1; j<=parseInt(i/2); j++){
            for(var a of dp[j]){
                for(var b of dp[i-j]){
                    if(!tmp.includes(a-b)) tmp.push(a-b)
                    if(!tmp.includes(b-a)) tmp.push(b-a)
                    if(!tmp.includes(a+b)) tmp.push(a+b)
                    if(!tmp.includes(a*b)) tmp.push(a*b)
                    if(b!=0)
                        if(!tmp.includes(parseInt(a/b)))
                            tmp.push(parseInt(a/b))
                    if(a!=0)
                        if(!tmp.includes(parseInt(b/a)))
                            tmp.push(parseInt(b/a))
                }
            }
        }
        if(tmp.includes(number)) return i
        dp.push(tmp)
    }
    return -1
}
