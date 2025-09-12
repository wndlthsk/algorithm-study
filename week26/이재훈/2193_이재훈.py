N = int(input())

dp = [[0] * 2 for _ in range(N + 1)]
# dp[n][k]: 길이가 n일 때, 마지막 자리가 k인 이친수의 개수
dp[1][0] = 0
dp[1][1] = 1
if N >= 2:
  dp[2][0] = 1
  dp[2][1] = 0

for i in range(3, N + 1):
  dp[i][0] = sum(dp[i - 1])
  dp[i][1] = dp[i - 1][0]
print(sum(dp[N]))