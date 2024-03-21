// 단어 변환 - BFS

/*
  24.03.21 (목)

  BFS의 경우 같은 깊이의 경우들을 같이 보기 때문에 먼저 나오는 게 답임
  while 안에 for이 중첩된 경우 한 번에 나가지지 않을 수 있음

  getChangeable에서 단순 각 단어의 알파벳이 불일치하는 개수로 로직을 짰는데, 위치로 고려를 해야했음
  각 단어에서 다른 알파벳의 개수 (X) -> 각 위치에 알파벳이 같지 않은 경우의 수 (O)
  이 때의 반례는 "aab", "aba", ["abb", "aba"]
  이런 조건의 경우 디버깅할 때 시간이 오래 걸릴 것 같으니 처음에 로직을 짤 때 조건을 잘 보는 게 좋겠다

  visited를 queue에 같이 넘겨주는 것으로 생각했는데, 다음으로 변경 가능한 단어의 수가 한번에 하나씩이어서 공통으로 관리해도 됐음
  dfs는 visited 배열을 파라미터에 같이 넘겨야 하는 경우가 많지만, bfs는 그렇지 않으니 처음에 visited를 전역으로 두고 먼저 해보고 안되면 변경해볼 것
*/

const getChangeable = (before, word) => {
    let diff = 0
    for (let i = 0; i < before.length; i++) {
        diff += before.charAt(i) !== word.charAt(i) ? 1 : 0
    }    
    return diff === 1
}

function solution(begin, target, words) {
    let answer = 0
    if (!words.includes(target)) {
        return answer
    }
    const visited = []
    
    const queue = [[begin, 0]]
    
    while (queue.length) {
        const [before, count] = queue.shift()
        
        // 이미 바꾼 단어 제거
        words.forEach((word) => {
            if (getChangeable(before, word) && !visited.includes(word)) {
                if (word === target) {
                    answer = count + 1
                    return
                }
                visited.push(word)
                queue.push([word, count + 1])
            }
        })
        if (answer !== 0) break
    }
    
    return answer
}
