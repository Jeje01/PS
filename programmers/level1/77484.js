// 로또의 최고 순위와 최저 순위

const getRanking = (correct) => correct < 2 ? 6 : 7 - correct;

const solution = (lottos, win_nums) => {
    const answer = [];
    let correct = 0;
    let possible = 0;
    lottos.forEach((num) => {
        if (num === 0) {
            possible++;
        } else if (win_nums.includes(num)) {
            correct++;
        }
    })
    answer.push(getRanking(correct + possible), getRanking(correct));
    return answer;
}
