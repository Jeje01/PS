// 모음사전

const solution = (word) => {
    let currentIndex = -1
    let answer = -1
    const dfs = (str, len) => {
        currentIndex ++
        if (str === word) {
            answer = currentIndex
            return
        }
        if (len === 5) {
            return
        }
        ['A', 'E', 'I', 'O', 'U'].forEach((letter) => {
            if (answer !== -1) {
                return false
            }
            dfs(str + letter, len + 1)
        })
    }
    dfs('', 0)
    return answer
}
