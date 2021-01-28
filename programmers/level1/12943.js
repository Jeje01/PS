// 콜라츠 추측

const solution = (num) => {
    let answer = 0;
    while (num !== 1 && answer <= 500) {
        num = num % 2 === 0 ? num / 2 : num * 3 + 1;
        answer ++;
    }
    if (answer === 501) {
        return -1;
    }
    return answer;
}
