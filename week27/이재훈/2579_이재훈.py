N = int(input())
score = [int(input()) for _ in range(N)]

dp = [[0] * 2 for _ in range(N + 1)]
# dp[i][k]: i번째 계단까지 움직인 최댓값. k: 이전에 연속된 계단 수.

dp[1][0] = 0
dp[1][1] = score[0]
if N >= 2:
  dp[2][0] = score[1]
  dp[2][1] = score[0] + score[1]

for i in range(3, N + 1):
  dp[i][0] = max(dp[i - 2]) + score[i - 1]
  dp[i][1] = dp[i - 1][0] + score[i - 1]
print(max(dp[N]))