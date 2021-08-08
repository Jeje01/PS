/**
 * Runtime: 84 ms, faster than 64.48% of JavaScript online submissions for Shuffle the Array.
 * Memory Usage: 40.7 MB, less than 49.63% of JavaScript online submissions for Shuffle the Array.
 *
 * for문 쓸 때 -> runtime: 92ms, memory: 40.3MB
 * while문 쓸 때 -> runtime: 84ms, memory: 40.7MB
 **/
const shuffle = (nums, n) => {
  const answer = []
  let i = 0
  while(i < n) {
    answer.push(nums[i], nums[n + i++])
  }
  return answer
}
