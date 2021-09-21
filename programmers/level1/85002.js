// 복서 정렬하기

const solution = (weights, head2head) => {
    let answer = []
    const winningRate = []
    const winHeavier = []
    for (let i = 1; i <= weights.length; i++) {
        answer.push(i)
    }
    head2head.forEach((head, i) => {
        let won = 0, game = 0, heavier = 0
        head.split("").forEach((letter, j) => {
            if (letter === "W") {
                won ++
                if (weights[i] < weights[j]) {
                    heavier ++
                }
            }
            if (letter !== "N") {
                game ++
            }
        })
        winningRate.push(game !== 0 ? won/game * 100 : 0)
        winHeavier.push(heavier)
    })
    answer.sort((a, b) => winningRate[b - 1] - winningRate[a - 1] || winHeavier[b - 1] - winHeavier[a - 1] || weights[b - 1] - weights[a - 1] || a - b)
    return answer
}
