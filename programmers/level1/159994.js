// 카드 뭉치

/**
  * pop() : 마지막 요소 제거, shirft() : 첫번째 요소 제거
**/

const solution = (cards1, cards2, goal) => {
    let answer = "Yes"
    for (let i = 0; i < goal.length; i++) {
        const nextWord = goal[i]
        if (cards1[0] === nextWord) {
            cards1.shift()
        } else if (cards2[0] === nextWord) {
            cards2.shift()
        } else {
            return "No"
        }
    }
    return answer
}
