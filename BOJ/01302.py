'''
베스트셀러 - S4
정렬
29,380 kb
68 ms
'''
n = int(input())
words = {}
for i in range(n):
  word = input()
  if word in words.keys():
    words[word]+=1
  else:
    words[word]=1

max_value = max(words.values())
li = []
for a in words:
  if words[a]==max_value:
    li.append(a)
sorted(li)
print(li[0])
