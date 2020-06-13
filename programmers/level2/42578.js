// 위장 - 해시

function solution(clothes) {
    var answer = 0, sep=[], cnt=0
    clothes = clothes.map(a => a[1])
    clothes.sort()
    for(var i in clothes){
        if(i==0){
            cnt++
            continue
        }
        if(clothes[i]==clothes[i-1]){
            cnt++
        }else{
            sep.push(cnt)
            cnt=1
        }
    }
    sep.push(cnt)
    answer = sep.reduce((a, b)=> a*(b+1), 1)-1
    return answer
}
