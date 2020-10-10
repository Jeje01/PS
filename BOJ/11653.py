'''
소인수분해 - S4
수학
29,380 kb
1,648 ms
'''
n = int(input())
i=2
while n!=1:
  if n%i==0:
    print(i)
    n/=i
  else:
    i+=1
