T = int(input())
for _ in range(T):
  a, b = map(int, input().split())
  
  cur = 1
  subfix = []
  while True:
    cur *= a
    sub = cur % 10
    if sub in subfix:
      break
    subfix.append(sub)
  
  idx = (b - 1) % len(subfix)
  res = subfix[idx]
  
  if res == 0:
    print(10)
  else:
    print(res)