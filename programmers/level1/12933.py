// 정수 내림차순으로 배치하기

def solution(n):
    numbers = list(str(n))
    return int(''.join(list(reversed(sorted(numbers)))))
