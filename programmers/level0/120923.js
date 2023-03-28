// 연속된 수의 합

/**
 * num이 홀수일 때 total / num 이 나누어떨어짐
 * num이 홀수인 경우와 짝수인 경우 시작값 구하는 식 분기만 필요
 */

const solution = (num, total) => {
    const median = Math.round(total / num)
    const startValue = median - (total % num === 0 ? num - 1 : num)/2
    const answer = []
    for (let i = 0; i < num; i++) {
        answer.push(startValue + i)
    }
    return answer
}
