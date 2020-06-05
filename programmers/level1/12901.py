// 2016년

def solution(a, b):
    cnt=b
    days = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];
    month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    for i in range(a-1):
        cnt += month[i]
    return days[(cnt-1)%7]
