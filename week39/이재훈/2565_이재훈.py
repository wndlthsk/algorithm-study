n = int(input())
lines = [tuple(map(int, input().split())) for _ in range(n)]

lines.sort(key=lambda x: x[0])

# dp[i] = i번째 전깃줄을 마지막으로 할 때, 겹치지 않게 선택할 수 있는 최대 전깃줄 개수
dp = [1] * n  

for i in range(n):
  for j in range(i):
    if lines[j][1] < lines[i][1]:
      dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))