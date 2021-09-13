// 4주차_직업군 추천하기

const solution = (table, languages, preference) => {
    let answer = ''
    const tableProcessed = []
    const sum = []
    table.forEach((tableRow, i) => {
        sum[i] = 0
        tableProcessed.push(tableRow.split(" "))
        for (let j = 0; j < preference.length; j++) {
            const index = tableProcessed[i].indexOf(languages[j]) 
            sum[i] += index !== -1 ? (6 - index) * preference[j] : 0
       }
    })
    let max = 0
    sum.forEach((value, i) => {
        if (value > max) {
            max = value
            answer = tableProcessed[i][0]
        } else if (value === max) {
            answer = answer < tableProcessed[i][0] ? answer : tableProcessed[i][0]
        }
    })
    return answer
}
