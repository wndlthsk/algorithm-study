T = int(input())
for _ in range(T):
  line = list(input())
  
  cnt = 0
  total = 0
  for ch in line:
    if ch == 'O':
      cnt += 1
    elif ch == 'X':
      cnt = 0
    total += cnt
  
  print(total)