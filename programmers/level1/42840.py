// 모의고사

def solution(answers):
    answer = []
    count = []
    pick = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    for a in pick:
        cnt=0
        for (i, ans) in enumerate(answers):
            if ans == a[i%len(a)]:
                cnt+=1
        count.append(cnt)   
    val = max(count)
    for i in range(len(count)):
        if count[i]==val:
            answer.append(i+1)
    answer.sort()
    return answer
