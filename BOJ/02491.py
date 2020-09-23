'''
수열 - S2
DP
31,292 kb
124 ms

가장 긴 수열이 될 수 있는 수열들은 겹치지 않아서 계산하기 편함
매번 max를 구하는 것보다 모든 수열의 길이를 모아서 마지막에 한 번만 계산하면 됨!
'''
n = int(input())
arr = input().split()
asc = 1
desc = 1
cnt = []
for i in range(n):
  if i==0:
    continue
  if arr[i]>=arr[i-1]:
   asc+=1
  else:
    cnt.append(asc)
    asc = 1
  if arr[i]<=arr[i-1]:
    desc+=1
  else:
    cnt.append(desc)
    desc = 1
cnt.append(desc)
cnt.append(asc)
print(max(cnt))
