/*
  2개 이하로 다른 비트
  
  N진법으로 바꾸기 : toString(N)
  N진법을 10진법으로 바꾸기 : parseInt(number, N)
  
  풀이
  1. 주어진 숫자보다 큰 숫자부터 순서대로 비트마스킹
    => 비효율적, 숫자가 커지면 오버플로우 남
  2. 마지막 숫자가 0인 경우 : 마지막 숫자만 1로 바꾸기
     마지막 숫자가 0이 아닌 경우 : 뒤에서부터 최초로 나오는 01 -> 10
*/

const solution = (numbers) => {
    let answer = [];
    numbers.forEach((number) => {
        let binary = number.toString(2)
        if (binary[binary.length - 1] === "0") {
            binary = binary.split("")
            binary[binary.length - 1] = "1"
            answer.push(parseInt(binary.join(""), 2))
        } else {
            binary = ("0" + binary).split("")
            for (let i = binary.length - 1; i >= 0; i--) {
                if (binary[i] === "0") {
                    binary[i] = "1"
                    binary[i + 1] = "0"
                    break;
                }
            }
            answer.push(parseInt(binary.join(""), 2))
        }
    })
    return answer;
}
