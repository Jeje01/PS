'''
슈퍼 마리오 - B1
구현
29,380 kb
68 ms
'''
sum = 0  
nums = []
for i in range(10):
  nums.append(int(input()))
for a in nums:
  sum+=a
  if sum>=100:
    answer = sum if abs(sum-100)<=abs(100-sum+a) else sum-a
    break
if sum<100:
  answer = sum
print(answer)
