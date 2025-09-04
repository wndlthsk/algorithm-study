N = int(input())
MOD = 10007
dp = [0] * (N + 1)
# dp[i]: 2*i일 때, 가능한 수
dp[1] = 1
if N >= 2:
  dp[2] = 2

for i in range(3, N + 1):
  dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
print(dp[N] % MOD)