// 상호평가

const checkGrade = (number) => {
    if (number >= 90) {
        return 'A'
    } else if (number >= 80) {
        return 'B'
    } else if (number >= 70) {
        return 'C'
    } else if (number >= 50) {
        return 'D'
    } else {
        return 'F'
    }
}

const solution = (scores) => {
    let answer = ""
    for (let i = 0; i < scores.length; i++) {
        let personalScore = scores.map((score) => score[i]).sort((a, b) => b - a)
        let score = personalScore.reduce((a, b) => a + b)
        let remove = (scores[i][i] === personalScore[0] && personalScore[0] !== personalScore[1]) || (scores[i][i] === personalScore[scores.length -1] && personalScore[scores.length - 1] !== personalScore[scores.length - 2])
        if (remove) {
            score -= scores[i][i]
            score /= scores.length - 1
        } else {
            score /= scores.length
        }
        answer += checkGrade(score)
    }
    return answer
}
