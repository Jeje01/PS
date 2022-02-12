/**
 * Runtime: 62 ms, faster than 98.10% of JavaScript online submissions for Maximum Number of Words Found in Sentences.
 * Memory Usage: 44.5 MB, less than 11.27% of JavaScript online submissions for Maximum Number of Words Found in Sentences.
 */

const mostWordsFound = (sentences) => {
    const numberOfWords = sentences.map((sentence) => (
        sentence.split(' ').length
    ))
    return Math.max(...numberOfWords)
}
