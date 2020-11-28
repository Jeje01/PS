// 제일 작은 수 제거하기

const solution = (arr) => {
    if(arr.length == 1) return [-1]
    else return arr.filter(a => a != Math.min(…arr))
}
