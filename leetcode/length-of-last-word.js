/**
 * Runtime: 64 ms, faster than 96.28% of JavaScript online submissions for Length of Last Word.
 * Memory Usage: 38.6 MB, less than 83.34% of JavaScript online submissions for Length of Last Word.
 *
 * slice -> 76ms, 38.7MB
 * splice -> 64ms, 38.6MB
 **/
const lengthOfLastWord = (s) => {
  return s.trim().split(" ").splice(-1)[0].length
}