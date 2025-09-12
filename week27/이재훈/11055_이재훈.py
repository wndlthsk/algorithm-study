N = int(input())
Ai = list(map(int, input().split()))

dp = [0] * (N + 1)
# dp[i]: i번째 요소를 마지막으로하는 수열의 최댓값.

dp[1] = Ai[0]

for i in range(2, N + 1):
  dp[i] = Ai[i - 1]   # 자기 자신만 선택한 경우
  for k in range(1, i):
    if Ai[k - 1] < Ai[i - 1]:
      dp[i] = max(dp[i], dp[k] + Ai[i - 1])
print(max(dp[1:]))