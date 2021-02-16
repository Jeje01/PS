// 하샤드 수

function solution(x) {
    var sum=0;
    (x+"").split("").forEach(a => sum+=a*1)
    return x%sum==0
}

// 2021.02.16

const solution = (x) => {
    let sum = 0
    x.toString().split("").forEach((x) => sum += Number.parseInt(x))
    return x%sum === 0
}
