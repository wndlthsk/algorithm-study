N = int(input())

dp = [0] * (N + 1)
# dp[i]: i번 눌러서 출력할 수 있는 A의 최대 개수

for i in range(1, N + 1):
  dp[i] = i
  for k in range(3, i):
    dp[i] = max(dp[i], dp[i - k] * (k - 1))
print(dp[N])