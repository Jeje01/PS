/**
 * Runtime: 136 ms, faster than 35.91% of JavaScript online submissions for Build Array from Permutation.
 * Memory Usage: 46.2 MB, less than 13.63% of JavaScript online submissions for Build Array from Permutation.
 */

const buildArray = (nums) => {
    const ans = []
    nums.forEach((num, i) => {
        ans[i] = nums[nums[i]]
    })
    return ans
}
