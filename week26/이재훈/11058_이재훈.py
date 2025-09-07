N = int(input())
dp = [0] * (N + 1)
# dp[i]: i번 눌러서 출력할 수 있는 A의 최대 개수

for i in range(1, N + 1):
  dp[i] = i

for i in range(1, N + 1):
  for j in range(3, i + 1):
    dp[i] = max(dp[i - j] * (j - 1), dp[i])
print(dp[N])