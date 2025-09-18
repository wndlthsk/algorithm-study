N = int(input())
Pi = list(map(int, input().split()))

dp = [0] * (N + 1)  # dp[i]: 카드 i개를 만들 때의 최대 금액

for i in range(1, N + 1):   # i개 카드를 살 때
  for j in range(1, i + 1):   # j개짜리 카드팩 사용
    dp[i] = max(dp[i], dp[i - j] + Pi[j - 1])
print(dp[N])