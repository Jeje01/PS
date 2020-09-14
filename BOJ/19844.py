'''
단어 개수 세기 - S4
브루트포스
29,380 kb
72 ms

단순 반복, 문자열
'''

a = input().replace('-', ' ').split(' ')
vowels = ['a', 'e', 'i', 'o', 'u']
pref = ['c\'', 'j\'', 'n\'', 'm\'', 't\'', 's\'', 'l\'', 'd\'', 'qu\'']
cnt = 0
for word in a:
  check = False
  for p in pref:
    if word.startswith(word):
      for vowel in vowels:
        if(word.startswith(p+vowel)):
          check = True
  if check:
    cnt+=2
  else:
    cnt+=1

print(cnt)
