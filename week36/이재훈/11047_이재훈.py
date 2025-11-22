N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]

cnt = 0
for coin in reversed(coins):  # 큰 동전부터 탐색
  if coin <= K:
    cnt += K // coin
    K %= coin
print(cnt)