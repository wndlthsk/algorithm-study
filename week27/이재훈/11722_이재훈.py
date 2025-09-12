N = int(input())
Ai = list(map(int, input().split()))

dp = [1] * (N + 1)
# dp[i]: i번째 요소를 마지막으로 하는 부분 수열의 길이 최댓값

for i in range(1, N + 1):
  for k in range(1, i):
    if Ai[k - 1] > Ai[i - 1]:
      dp[i] = max(dp[i], dp[k] + 1)
print(max(dp))