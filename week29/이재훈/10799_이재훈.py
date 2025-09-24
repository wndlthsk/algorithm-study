line = list(input())

stick = 0  # 열린 막대 개수
res = 0
for i in range(len(line)):
  if line[i] == '(':
    stick += 1
  else:  # ')'
    stick -= 1
    if line[i-1] == '(':  # 레이저
      res += stick
    else:  # 막대 끝
      res += 1
print(res)