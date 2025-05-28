n = int(input())

drink = [int(input()) for _ in range(n)]

dp = [[0] * 3 for _ in range(n + 1)] # 최대로 마실 수 있는 포도주의 양
dp[1][0] = 0 # 1열 안 마심
dp[1][1] = drink[0] # 1열만 마심 (1 - 1열 안 마심)
dp[1][2] = 0 # 1열, 그 1 - 1열 마심. 0열은 없으므로 불가능한 상황 -> 0.

for i in range(2, n + 1):
  dp[i][0] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
  dp[i][1] = (dp[i - 1][0]) + drink[i - 1]
  dp[i][2] = (dp[i - 1][1]) + drink[i - 1]
print(max(dp[n]))

# dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) 왜 안되는가?
# i-2열 안마신 경우, i-2열 마신 경우. 2개가 동시에 존재할 수 없음.
# -> 서로 양립 불가능한 경로를 더해버린 오류.