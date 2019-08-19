fruit = ["apple", "banana", "cacao", "apple", "peach", "banana", "grape"]

d = {}

for f in fruit:
  if f in d : 
  #fruit의 key가 d라는 dictionary에 있는지 확인
    d[f] = d[f] + 1
  else:
    d[f] = 1
    #key가 없으면, 그걸 dictionary에 넣고 value는 1로 만듬

print(d)
