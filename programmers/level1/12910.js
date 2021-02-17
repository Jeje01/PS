// 나누어 떨어지는 숫자 배열

function solution(arr, divisor) {
    var ans = arr.filter(el => el%divisor==0);
    return ans.length!=0? ans.sort((a, b) => a-b) : [-1];
}

// 2021.02.17

const solution = (arr, divisor) => {
    arr = arr.filter((num) => num % divisor === 0).sort((a, b) => a - b)
    arr = arr.length === 0 ? [-1] : arr;
    return arr
}
