import math

T = int(input())
for _ in range(T):
  M, N, x, y = map(int, input().split())
  
  limit = math.lcm(M, N)
  year = x
  while year <= limit:
    cur_y = (year - 1) % N + 1
    if cur_y == y:
      print(year)
      break
    year += M
  
  if year > limit:
    print(-1)