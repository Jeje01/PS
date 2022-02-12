/**
 * Runtime: 59 ms, faster than 98.03% of JavaScript online submissions for Number of Good Pairs.
 * Memory Usage: 41.9 MB, less than 22.80% of JavaScript online submissions for Number of Good Pairs.
 */

const numIdenticalPairs = (nums) => {
    let answer = 0
    for (let i = 0; i < nums.length - 1; i++) {
        const current = nums[i]
        for(let j = i + 1; j < nums.length; j++) {
            if (current === nums[j]) {
                answer ++
            }
        }
    }
    return answer
}
