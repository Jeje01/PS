// 종이접기

def solution(n):
    answer = [0]
    for a in range(1, n):
        answer = answer + [0]
        length = len(answer)
        for i in range(length):
            answer.append(1-answer[length-i-2])
    return answer
