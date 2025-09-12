N = int(input())
amounts = [int(input()) for _ in range(N)]

dp = [[0] * 3 for _ in range(N + 1)]

dp[1][0] = 0
dp[1][1] = amounts[0]
dp[1][2] = 0

if N >= 2:
  dp[2][0] = max(dp[1])
  dp[2][1] = dp[1][0] + amounts[1]
  dp[2][2] = dp[1][1] + amounts[1]

for i in range(3, N + 1):
  dp[i][0] = max(dp[i-1])                           # 이번 잔 안 마심
  dp[i][1] = dp[i-1][0] + amounts[i-1]              # 이번 잔만 마심
  dp[i][2] = dp[i-1][1] + amounts[i-1]              # 직전과 이번 잔 마심
print(max(dp[N]))
