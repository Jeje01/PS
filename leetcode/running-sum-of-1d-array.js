/**
 * Runtime: 80 ms, faster than 45.39% of JavaScript online submissions for Running Sum of 1d Array.
 * Memory Usage: 40.1 MB, less than 40.57% of JavaScript online submissions for Running Sum of 1d Array.
 **/
const runningSum = (nums) => {
  const answer = [nums[0]]
  nums.reduce((a, c) => {
    answer.push(a + c)
    return a + c
  })
  return answer
}