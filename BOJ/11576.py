'''
Base Conversion
29,380 kb
72 ms
'''
line = input().split()
a = int(line[0])
b = int(line[1])
n = int(input())
line = input().split()
answer=[]
mul = 1
total = 0
for i in range(len(line)):
  idx = len(line)-i-1
  tmp = int(line[idx])
  total += mul*tmp
  mul*=a
while total!=0:
  answer.append(total%b)
  total//=b
answer.reverse()
p = ""
for item in answer:
  p+=str(item)+" "
print(p)
