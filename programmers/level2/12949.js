// 행렬의 곱셈

const solution = (arr1, arr2) => {
    const answer = []
    for (let i = 0; i < arr1.length; i++) {
        answer.push([])
    }
    arr1.forEach((row1, index) => {
        for (let i = 0; i < arr2[0].length; i++) {
            let tmp = 0
            row1.forEach((a, j) => {
                tmp += a*arr2[j][i]
            })
            answer[index].push(tmp)
        }
    }) 
    return answer
}
