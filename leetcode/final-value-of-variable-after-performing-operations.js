// 1
/**
 * Runtime: 87 ms, faster than 56.81% of JavaScript online submissions for Final Value of Variable After Performing Operations.
 * Memory Usage: 44.1 MB, less than 5.63% of JavaScript online submissions for Final Value of Variable After Performing Operations.
 */

const finalValueAfterOperations = (operations) => {
    const isIncrement = (str) => ["++X", "X++"].includes(str)
    let answer = 0
    operations.forEach((operation) => {
        if (isIncrement(operation)) {
            answer ++
        } else {
            answer --
        }
    })
    return answer
}
