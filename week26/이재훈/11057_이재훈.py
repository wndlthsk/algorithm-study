N = int(input())
MOD = 10_007
dp = [[0] * 10 for _ in range(N + 1)]
# dp[n][k]: 길이가 n이고, 마지막 자릿수가 k인 오르막의 개수

for k in range(10):
  dp[1][k] = 1

for n in range(2, N + 1):
  for k in range(10):
    dp[n][k] = sum(dp[n - 1][:k+1]) % MOD
print(sum(dp[N]) % MOD)