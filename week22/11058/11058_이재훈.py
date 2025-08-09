N = int(input())

dp = [0] * (N+1)

for i in range(1, N+1):
  # 1. 그냥 A를 입력하는 경우
  dp[i] = dp[i-1] + 1
  # 2. 붙여넣기 전략
  for j in range(1, i-2):  # 최소 3번은 남겨야 Ctrl-A, Ctrl-C, Ctrl-V 가능
    dp[i] = max(dp[i], dp[j] * (i-j-1))
print(dp[N])
