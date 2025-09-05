T = int(input())

dp = [0] * 11
# dp[i]: 정수 i를 1,2,3의 합으로 나타내는 방법의 수
dp[1] = 1
dp[2] = 1 + 1
dp[3] = 1 + 2 + 1

for i in range(4, 11):
  dp[i] = dp[i - 1] # +1을 하는 경우 (i-1을 만드는 모든 경우 뒤에 +1을 붙여서 i를 만드는 경우)
  dp[i] += dp[i - 2] # +2를 하는 경우
  dp[i] += dp[i - 3] # +3을 하는 경우

for _ in range(T):
  n = int(input())
  print(dp[n])