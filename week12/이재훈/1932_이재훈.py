n = int(input())

dp = [list(map(int, input().split())) for _ in range(n)] # 최대가 되는 경로에 있는 수의 합

for i in range(1, n):
  for j in range(i + 1):
    if j == 0:
      dp[i][j] = dp[i - 1][j] + dp[i][j]
    elif j == i:
      dp[i][j] = dp[i - 1][j - 1] + dp[i][j]
    else:
      dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + dp[i][j]
print(max(dp[n - 1]))

# dp[0][0] = 7 # i=0행에서 0번열
# dp[1][0] = 3 # i=1행에서 0번열
# dp[1][1] = 8 # i=1행에서 1번열