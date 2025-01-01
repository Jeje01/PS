// 가장 가까운 같은 글자

/**
 처음에 기본 테케는 통과하는데 제출하면 거의 틀림
 테케 "aaaaa"를 넣어보니 [-1, 1, 1, 1, 1] 이어야 하는데 [-1, -1, 1, 1, 1]이 나옴
 !check[nextLetter] 이 조건으로 체크를 했었는데 0이 falsy하다는 걸 간과함
 check[nextLetter] === undefined 조건으로 수정하니 됨
**/

const solution = (s) => {
    const check = {}
    const answer = []
    for (let i = 0; i < s.length; i++) {
        const nextLetter = s[i]
        if (check[nextLetter] === undefined) {
            answer.push(-1)
        } else {
            answer.push(i - check[nextLetter])
        }
        check[nextLetter] = i
    }
    return answer
}
