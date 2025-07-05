N = int(input())

dp = [False] * max(4, N + 1)
dp[1] = True  # SK
dp[2] = False # CY
dp[3] = True  # SK

for i in range(4, N + 1):
  if dp[i - 1] and dp[i - 3]:
    dp[i] = False # 1개, 3개를 가져가는 경우 모두 CY가 승리 → SK는 무조건 짐
  else:
    dp[i] = True # 하나라도 CY의 승리가 아닌 경우가 존재하면 -> SK의 승리
print('SK' if dp[N] else 'CY')