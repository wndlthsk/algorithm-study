N, S, M = map(int, input().split())

Vol = list(map(int,input().split()))

# dp[i][v] = i번째 곡을 연주할 때 볼륨이 v일 수 있는가
dp = [[False] * (M + 1) for _ in range(N + 1)]
dp[0][S] = True  # 시작 볼륨

for i in range(N):
  for v in range(M + 1):
    if dp[i][v]:
      if v + Vol[i] <= M:
        dp[i + 1][v + Vol[i]] = True
      if v - Vol[i] >= 0:
        dp[i + 1][v - Vol[i]] = True

# 마지막 곡에서 가능한 볼륨 중 최댓값 찾기
res = -1
for v in range(M, -1, -1):
  if dp[N][v]:
    res = v
    break
print(res)