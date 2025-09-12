N = int(input())
Ai = list(map(int, input().split()))

dp = [1] * (N + 1)  # 자기 자신만 있는 경우 길이 = 1

for i in range(1, N + 1):
  for j in range(1, i):  # i보다 앞쪽 원소들 확인
    if Ai[j - 1] < Ai[i - 1]:  # 증가 조건
      dp[i] = max(dp[i], dp[j] + 1)
print(max(dp))