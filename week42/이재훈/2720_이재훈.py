T = int(input())
for _ in range(T):
  total = int(input())
  remain = total
  
  q = remain // 25
  remain %= 25
  
  d = remain // 10
  remain %= 10
  
  n = remain // 5
  remain %= 5
  
  p = remain // 1
  remain %= 1
  
  print(q, d, n, p)