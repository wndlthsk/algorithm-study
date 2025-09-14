N = int(input())
Ai = list(map(int, input().split()))

dp = [0] * (N + 1)
# dp[i]: i번째 요소를 마지막으로하는 연속된 수 중 최대합

for i in range(1, N + 1):
  dp[i] = Ai[i - 1]
  dp[i] = max(dp[i], dp[i - 1] + Ai[i - 1])
print(max(dp[1:]))
