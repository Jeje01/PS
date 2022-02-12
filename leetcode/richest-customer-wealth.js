/**
 * Runtime: 61 ms, faster than 89.44% of JavaScript online submissions for Richest Customer Wealth.
 * Memory Usage: 42.7 MB, less than 10.75% of JavaScript online submissions for Richest Customer Wealth.
 */

const maximumWealth = (accounts) => {
    accounts = accounts.map((account) => (
        account.reduce((a, b) => a + b)
    ))
    return Math.max(...accounts)
}
