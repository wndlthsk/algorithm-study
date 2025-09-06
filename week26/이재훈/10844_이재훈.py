N = int(input())
MOD = 1_000_000_000
dp = [[0] * 10 for _ in range(N + 1)]
# dp[n][k]: 길이가 n이고, 마지막 자리가 k인 계단 수의 개수

# 초기값
for k in range(1, 10):
  dp[1][k] = 1

# 점화식
for n in range(2, N + 1):
  for k in range(10):
    if k == 0:
      dp[n][k] = dp[n - 1][1] % MOD
    elif k == 9:
      dp[n][k] = dp[n - 1][8] % MOD
    else:
      dp[n][k] = (dp[n - 1][k - 1] + dp[n - 1][k + 1]) % MOD
print(sum(dp[N]) % MOD)