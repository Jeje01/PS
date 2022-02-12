// 1
/**
 * Runtime: 133 ms, faster than 34.01% of JavaScript online submissions for Concatenation of Array.
 * Memory Usage: 46.3 MB, less than 7.07% of JavaScript online submissions for Concatenation of Array.
 */

const getConcatenation = (nums) => {
    return [... nums, ... nums]
}


// 2
/**
 * Runtime: 114 ms, faster than 51.33% of JavaScript online submissions for Concatenation of Array.
 * Memory Usage: 44.9 MB, less than 24.54% of JavaScript online submissions for Concatenation of Array.
 */

const getConcatenation = (nums) => {
    nums.forEach((num) => {
        nums.push(num) 
    })
    return nums
}

// 3
/**
 * Runtime: 92 ms, faster than 76.67% of JavaScript online submissions for Concatenation of Array.
 * Memory Usage: 45.3 MB, less than 19.66% of JavaScript online submissions for Concatenation of Array.
 */

const getConcatenation = (nums) => {
    return nums.concat(nums)
}
