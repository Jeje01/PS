// 하샤드 수

function solution(x) {
    var sum=0;
    (x+"").split("").forEach(a => sum+=a*1)
    return x%sum==0
}
