// 행렬의 덧셈

const solution = (arr1, arr2) => {
    const answer = []
    arr1.forEach((a, i) => {
        let tmp = []
        a.forEach((b, j) => {
            tmp.push(arr1[i][j] + arr2[i][j])
        })
        answer.push(tmp)
    })
    return answer
}

// 20210204
const solution = (arr1, arr2) => {
    arr1.forEach((a, i) => {
        a.forEach((b, j) => {
            arr1[i][j] += arr2[i][j]
        })
    })
    return arr1
}
