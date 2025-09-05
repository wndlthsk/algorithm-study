N = int(input())
MOD = 10_007
dp = [0] * (N + 1)
# dp[i] = 2 * i 방법의 수
dp[1] = 1
if N >= 2:
  dp[2] = 3

for i in range(3, N + 1):
  dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % MOD
print(dp[N] % MOD)