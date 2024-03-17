// 정수 삼각형 - DP

// 24.03.17 (일)
const solution = (triangle) => {
    if (triangle.length === 1) {
        return triangle[0][0]
    }
    for (let i = 1; i < triangle.length; i++) {
        for (let j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.max(triangle[i - 1][j-1] ? triangle[i - 1][j-1] : 0, triangle[i - 1][j] ? triangle[i - 1][j] : 0)
        }
    }
    
    return Math.max(...triangle[triangle.length - 1])
}
