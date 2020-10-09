'''
접미사 배열 - S4
문자열, 정렬
29,512 kb
72 ms
'''
word = input()
arr = []
for i in range(len(word)):
  arr.append(word[i:])
arr.sort()
for a in arr:
  print(a) 
