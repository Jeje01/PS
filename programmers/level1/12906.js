// 같은 숫자는 싫어

function solution(arr)
{
    var answer = [];
    answer.push(arr[0]);
    for(var i=1; i<arr.length; i++){
        if(arr[i]!=arr[i-1])
            answer.push(arr[i]);
    }
    return answer;
}

// 2021.02.03
const solution = (arr) => {
    const answer = []
    arr.forEach((num) => {
        if (answer[answer.length - 1] !== num){
            answer.push(num)
        }
    })
    return answer
}

// 2021.03.06
const solution = (arr) => {
    const answer = []
    arr.forEach((a, i) => {
        if (!i) {
            answer.push(a)
        } else {
            if (a !== answer[answer.length - 1]) {
                answer.push(a)
            }
        }
    })
    return answer
}

// 2024.03.22
const solution = (arr) => {
    const answer = [arr[0]]
    for (let i = 1; i < arr.length; i ++) {
        if (answer[answer.length - 1] !== arr[i]) {
            answer.push(arr[i])
        }
    }
    return answer
}
