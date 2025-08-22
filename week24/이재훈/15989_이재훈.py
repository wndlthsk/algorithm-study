T = int(input())
MAX = 10000

dp = [[0] * (MAX + 1) for _ in range(4)]

# 0을 만드는 방법은 "아무것도 안 쓰는 것" 1가지
dp[1][0] = 1
dp[2][0] = 1
dp[3][0] = 1

for i in range(1, 4):
  for j in range(1, MAX + 1):
    dp[i][j] = dp[i - 1][j]  # i를 안 쓰는 경우
    if j - i >= 0:
      dp[i][j] += dp[i][j - i]  # i를 쓰는 경우 (무조건 i를 써야함. 안쓰면 dp[i-1]상황과 동일해지기 때문.)

for _ in range(T):
  n = int(input())
  print(dp[3][n])