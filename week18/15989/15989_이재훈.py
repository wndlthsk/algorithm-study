T = int(input())

MAX = 10001
dp = [[0] * 4 for _ in range(MAX)]  # dp[n][k]: n을 1~k를 써서 만드는 조합 수

# 초기 조건
for i in range(1, 4):
  dp[0][i] = 1

for n in range(1, MAX):
  for k in range(1, 4):  # 숫자 1, 2, 3
    if n - k >= 0:
      dp[n][k] = dp[n][k - 1] + dp[n - k][k]
    else:
      dp[n][k] = dp[n][k - 1]  # 더 이상 해당 숫자 못 쓰는 경우

for _ in range(T):
  n = int(input())
  print(dp[n][3])  # 1,2,3까지 고려한 조합 수