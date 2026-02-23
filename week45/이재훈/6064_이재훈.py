T = int(input())
for _ in range(T):
  M, N, x, y = map(int, input().split())
  
  is_valid = False
  k = x
  
  while k <= M * N:
    if (k - 1) % N + 1 == y:
      print(k)
      is_valid = True
      break
    k += M
  
  if not is_valid:
    print(-1)