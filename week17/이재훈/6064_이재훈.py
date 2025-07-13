T = int(input())

for _ in range(T):
  M, N, x, y = map(int, input().split())
  
  is_valid = False
  k = x  # x부터 시작 (K ≡ x mod M)
  
  while k <= M * N:  # 최대 범위는 M과 N의 최소공배수까지
    if (k - 1) % N + 1 == y:
      print(k)
      is_valid = True
      break
    k += M
  
  if not is_valid:
    print(-1)