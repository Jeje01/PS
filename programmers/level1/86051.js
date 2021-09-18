// 없는 숫자 더하기

const solution = (numbers) => {
    let answer = 0
    const arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    arr.forEach((num) => {
        answer += numbers.includes(num) ? 0 : num
    })
    return answer
}
