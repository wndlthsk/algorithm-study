N = int(input())

dp = [0] * (N + 1)

if N % 2 == 1:  # 홀수는 경우 없음
  print(0)
  exit()

dp[0] = 1  # 아무것도 채우지 않는 경우
dp[2] = 3

for i in range(4, N + 1, 2):
  dp[i] = dp[i - 2] * 3 # (1) 기본 3가지 경우
  for j in range(4, i + 1, 2):
    dp[i] += dp[i - j] * 2  # (2) 특수한 경우 2가지씩 추가
print(dp[N])
