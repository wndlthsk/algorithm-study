N, K = map(int, input().split())
MOD = 1_000_000_000

dp = [[0] * (K + 1) for _ in range(N + 1)]
# dp[n][k]: n을 k개의 수의 합으로 나타내는 경우의 수

# n=0은 어떤 k든 1가지 (전부 0으로 표현 가능)
for k in range(K + 1):
  dp[0][k] = 1

for n in range(1, N + 1):
  for k in range(1, K + 1):
    dp[n][k] = (dp[n - 1][k] + dp[n][k - 1]) % MOD
print(dp[N][K])