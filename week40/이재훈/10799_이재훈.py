s = input().strip()

open_cnt = 0
pieces = 0

for i in range(len(s)):
  if s[i] == '(':
    open_cnt += 1
  else:
    open_cnt -= 1
    if s[i - 1] == '(':
      pieces += open_cnt
    else:
      pieces += 1

print(pieces)