// 문자열 내 p와 y의 개수

def solution(s):
    s = s.lower()
    y=0
    p=0
    for a in s:
        if a=="y":
            y=y+1
        elif a=="p":
            p=p+1
    return p==y
