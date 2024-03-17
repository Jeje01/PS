// 연속 부분 수열 합의 개수

// 24.03.17 (일)
const solution = (elements) => {
    const len = elements.length
    elements = [...elements, ...elements]
    const set = new Set()
        
    for (i = 0; i < len; i++) {
        for (j = 1; j <= len; j++) {
            const sum = elements.slice(i, i + j).reduce((a, b) => a + b, 0)
            set.add(sum)
        }
    }
    return set.size
}

/*
  개선
  첫번째 반복문 안에 sum을 두고 하나씩 더할 때마다 set에 추가해주면 반복을 줄일 수 있음
*/
for (i = 0; i < len; i++) {
    let sum = 0
    for (j = 1; j <= len; j++) {
        sum += elements[i + j]
        set.add(sum)
    }
}

