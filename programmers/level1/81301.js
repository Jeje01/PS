// 숫자 문자열과 영단어

// 1
const solution = (s) => {
    let answer = ""
    const numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    let i = 0
    while (i !== s.length) {
        if (!isNaN(s[i])) {
            answer += s[i++]
        } else {
            switch(s[i]) {
                case 'z': 
                    answer += "0"
                    i += 4
                    break;
                case 'o':
                    answer += "1"
                    i += 3
                    break;
                case 't':
                    if (s[i + 1] === 'w') {
                        answer += "2"
                        i += 3
                    } else {
                        answer += "3"
                        i += 5
                    }
                    break;
                case 'f':
                    if (s[i + 1] === 'o') {
                        answer += "4"
                        i += 4
                    } else {
                        answer += "5"
                        i += 4
                    }
                    break;
                case 's':
                    if (s[i + 1] === 'i') {
                        answer += "6"
                        i += 3
                    } else {
                        answer += "7"
                        i += 5
                    }
                    break;
                case 'e':
                    answer += "8"
                    i += 5
                    break;
                case 'n':
                    answer += "9"
                    i += 4
                    break;
            }
        }
    }
    return Number(answer)
}

// 2
const solution = (s) => {
    const answer = s.replace(/zero/gi, '0')
        .replace(/one/gi, '1')
        .replace(/two/gi, '2')
        .replace(/three/gi, '3')
        .replace(/four/gi, '4')
        .replace(/five/gi, '5')
        .replace(/six/gi, '6')
        .replace(/seven/gi, '7')
        .replace(/eight/gi, '8')
        .replace(/nine/gi, '9')
    return Number(answer)
}
