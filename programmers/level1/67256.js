// [카카오 인턴] 키패드 누르기

let leftHand = 11
let rightHand = 12
const distance = [
    [0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 0, 1, 1],
    [],
    [3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 0, 4, 4],
    [],
    [],
    [2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 0, 3, 3],
    [],
    [],
    [1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 0, 2, 2]
]

const solution = (numbers, hand) => {
    let answer = ""
    numbers.forEach((number) => {
        answer += getUsedHand(number, hand === "right" ? "R" : "L")  
    })    
    return answer
}

const getUsedHand = (number, hand) => {
    switch (number) {
        case 1:
        case 4:
        case 7:
            leftHand = number;
            return 'L'
        case 3:
        case 6:
        case 9:
            rightHand = number
            return 'R'
        default:
            if (distance[number][leftHand] > distance[number][rightHand]) {
                rightHand = number
                return 'R'
            } else if (distance[number][leftHand] < distance[number][rightHand]) {
                leftHand = number
                return 'L'
            } else {
                hand === 'R' ? rightHand = number : leftHand = number
                return hand
            }
    }
}
