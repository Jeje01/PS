// 나누어 떨어지는 숫자 배열

function solution(arr, divisor) {
    var ans = arr.filter(el => el%divisor==0);
    return ans.length!=0? ans.sort((a, b) => a-b) : [-1];
}
