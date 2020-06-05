// k번째수

def solution(array, commands):
    answer = []
    for a in commands:
        tmp = array[a[0]-1: a[1]]
        tmp.sort()
        answer.append(tmp[a[2]-1])
    return answer
