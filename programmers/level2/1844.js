// 게임 맵 최단거리 - BFS

/*
  24.03.19 (화)

  처음에 DFS로 풀었다.
  visited 배열을 같이 넘기니 visited가 제대로 변하지 않았다.
  2차원 배열을 1차원 배열로 바꿨다가 그냥 스트링으로 바꿔서 넘겼다.
  1차원 배열 인덱스를 계산할 때 x*cols+y로 해야하는데 rows를 썼다. 

  BFS로 풀면 같은 count의 경로를 다 보고 다음 count 경로 다 보고 이런식으로 하기 때문에 최단 경로가 나오면 멈추면 되어 효율성이 더 높다.
  BFS로 구현 후에도 효율성 통과를 못했는데 이때는 
  maps[nx][ny] = 0 <- visited 체크를 dirs.forEach 돌릴 때 말고 queue에서 뺀 후에 했기 때문이다. 
  queue에 넣고 바로 해버리면 된다. 
  1 B
  A 2
  이 때 A에서 B로 가는 경우에 1에서 B의 visited를 체크해버리면 2에서 탐색할 때 B가 또 큐에 들어가지 않아도 된다. 
*/

// DFS 코드 - 효율성 통과 X
function solution(maps) {
    const dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]] // 북0, 남1, 동2, 서3
    const rows = maps.length
    const cols = maps[0].length
    let minLength = Infinity
    let arr = maps.flat().toString()
    
    const dfs = (x, y, length, array) => {
        if (x === rows - 1 && y === cols - 1) {
            minLength = Math.min(minLength, length)
            return
        }
                
        let nArr = array.split(",").map(Number)
        nArr[x*cols + y] = 0
        dirs.forEach(([a, b]) => {
            const nx = x + a
            const ny = y + b
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && nArr[nx*cols + ny] !== 0 && length +1 <= minLength) {
                dfs(nx, ny, length + 1, nArr.toString())
            }
        })
        return
    }
    
    dfs(0, 0, 1, arr)
    
    return minLength === Infinity ? -1 : minLength;
}

// BFS 코드 - 전체 통과 O
function solution(maps) {
    const dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]] // 북0, 남1, 동2, 서3
    const rows = maps.length
    const cols = maps[0].length
    let answer = -1
    let arr = maps.flat().toString()
    const queue = [[0, 0, 1]]
    
    while (queue.length) {
        const [x, y, len] = queue.shift()
        // console.log(x, y, len)
        
        if (x === rows - 1 && y === cols - 1) {
            return len
        }
        dirs.forEach(([a, b]) => {
            const nx = x + a
            const ny = y + b
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maps[nx][ny] === 1) {
                queue.push([nx, ny, len + 1])
                maps[nx][ny] = 0
            }
        })
    }
    
    return -1
}
