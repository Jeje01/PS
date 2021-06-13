// 약수의 개수와 덧셈

const solution = (left, right) => {
    let answer = 0;
    for (let i = left; i <= right; i++) {
        let cnt = 0;
        for (let j = 2; j <= i; j++) {
            if (i % j === 0) {
                cnt++;
            }
        }
        (cnt + 1) % 2 === 0 ? answer += i : answer -= i;
    }
    return answer;
}
