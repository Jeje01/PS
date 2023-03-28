// 다음에 올 숫자

const solution = (common) => {
    const firstGap = common[1] - common[0]
    const secondGap = common[2] - common[1]
    const lastElementIndex = common.length - 1
    if (firstGap === secondGap) {
        return common[lastElementIndex] + firstGap
    } else {
        return common[lastElementIndex] * common[1] / common[0]
    }
}
