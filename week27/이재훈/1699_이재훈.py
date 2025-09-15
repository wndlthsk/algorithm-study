import math
N = int(input())

dp = [0] * (N + 1)

for i in range(1, N + 1):
  dp[i] = i  # 최악의 경우: 1^2 + 1^2 + ... (i번)
  
  max_square = int(math.sqrt(i))  # i 이하의 최대 제곱수
  for j in range(1, max_square + 1):
    dp[i] = min(dp[i], dp[i - j*j] + 1)
print(dp[N])
