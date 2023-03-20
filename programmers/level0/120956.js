// 옹알이 (1)

const solution = (babbling) => {
    let speakableWords, i, j, answer = 0
    babbling.forEach((bab) => {
        speakableWords = ["aya", "ye", "woo", "ma"]
        i = 0
        while (i < bab.length) {
            for (j = 0; j < speakableWords.length; j++) {
                const word = speakableWords[j]
                if (bab.substring(i).startsWith(word)) {
                    i += word.length
                    break
                }
            }
            if (j === speakableWords.length) {
                break
            }
            speakableWords.splice(j, 1)
            if (i === bab.length) {
                answer ++
            }
        }
    })
    return answer
}
