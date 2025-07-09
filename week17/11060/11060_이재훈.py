### 첫번째 푼 방식
N = int(input())

Ai = list(map(int, input().split()))

dp = [[False] * 3 for _ in range(N + 1)]
dp[0][1] = True # i칸에서 j칸 움직일 때.

for i in range(1, N + 1):
  for j in range(3):
    dp[i][1] = max(dp[i - 1][1] + dp[i - 1][j])
    dp[i][2] = max(dp[i - 1][2] + dp[i - 1][j])
    dp[i][3] = max(dp[i - 1][3] + dp[i - 1][j])

res = -1
for i in range(3):
  if dp[N][i]:
    res = max(dp[N][i])
print(res)

### 두번째 푼 방식
N = int(input())

Ai = list(map(int, input().split()))

INF = 1001
dp = [INF] * N  # dp[i]: i번째 칸에 도달하는 최소 점프 수
dp[0] = 0  # 시작점은 점프 0번

for i in range(N):
  for j in range(1, Ai[i] + 1):
    if i + j < N:
      dp[i + j] = min(dp[i + j], dp[i] + 1)

if dp[N - 1] == INF:
  print(-1)  # 도달 불가
else:
  print(dp[N - 1])  # 최소 점프 수 출력