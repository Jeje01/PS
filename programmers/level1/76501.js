// 음양 더하기

const solution = (absolutes, signs) => {
    let answer = 0;
    absolutes.forEach((absolute, i) => {
        answer += signs[i] ? absolute : absolute*(-1); 
    })
    return answer;
}
