/**
 * Runtime: 95 ms, faster than 49.84% of JavaScript online submissions for Valid Parentheses.
 * Memory Usage: 42.3 MB, less than 23.46% of JavaScript online submissions for Valid Parentheses.
 */

const isValid = (s) => {
    const opened = ['(', '[', '{']
    const closed = [')', ']', '}']
    const stack = []
    for (let i = 0; i < s.length; i++) {
        const current = s.charAt(i)
        if (opened.includes(current)) { // 여는 괄호일 때
            stack.push(current)
        } else { // 닫는 괄호일 때
            if (stack.length === 0) {
                return false
            }
            if (closed.indexOf(current) === opened.indexOf(stack[stack.length - 1])) {
                stack.pop()
            } else {
                return false
            }
        }
    }
    return stack.length === 0
}
