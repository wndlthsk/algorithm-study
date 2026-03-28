N, K = map(int, input().split())
Ai = [int(input()) for _ in range(N)]

total = 0
cnt = 0
for coin in reversed(Ai):
  if coin > K:
    continue
  
  cnt += K // coin
  K %= coin
print(cnt)