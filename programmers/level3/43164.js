// 여행경로 - BFS

/*
  24.03.21 (목)

  두 가지가 문제였음

  1. localeCompare을 사용해서 문자열을 비교해야 함
  
  2. 여기서 nextVisited[index]가 아닌 visited[index]를 사용해서 해서 문제였음
  let nextVisited = [...visited]
  nextVisited[index] = true
  
*/

const solution = (tickets) => {
    const answer = []
    const len = tickets.length + 1
    const queue = []
    let visited = new Array(len - 1).fill(false)

    tickets.forEach(([start, end], index) => {
        if (start === "ICN") {
            let nextVisited = [...visited]
            nextVisited[index] = true
            queue.push([[start, end], nextVisited])
        }
    })
    
    while(queue.length) {
        const [route, queueVisited] = queue.shift()
        const recentDest = route[route.length - 1]
          
        if (route.length === len) {
            answer.push(route)
            continue
        }
        
        tickets.forEach(([start, end], index) => {
            if (!queueVisited[index] && start === recentDest) {
                let nextVisited = [...queueVisited]
                nextVisited[index] = true
                queue.push([[...route, end], nextVisited])
            }
        })
    }
    answer.sort((a, b) => a.join("").localeCompare(b.join("")))
    return answer[0]
}
