T = int(input())
for _ in range(T):
  words = input().split()
  
  res = []
  for word in words:
    res.append(word[::-1])
  
  print(' '.join(res))
