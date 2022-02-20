/**
 * Runtime: 68 ms, faster than 91.02% of JavaScript online submissions for Kids With the Greatest Number of Candies.
 * Memory Usage: 42.6 MB, less than 15.65% of JavaScript online submissions for Kids With the Greatest Number of Candies.
 */
const kidsWithCandies = (candies, extraCandies) => {
    const maxCandies = Math.max(...candies)
    const maxPossibleCandy = maxCandies - extraCandies
    return candies.map((candy) => candy >= maxPossibleCandy)
}
