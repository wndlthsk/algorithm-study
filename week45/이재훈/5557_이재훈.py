N = int(input())
numbers = list(map(int, input().split()))

MAX = 20
dp = [[0] * (MAX + 1) for _ in range(N)]
dp[0][numbers[0]] = 1 # dp[i][v]: i번째 숫자까지 사용해서, 값 v를 만들 수 있는 경우의 수

for i in range(1, N - 1):
  for v in range(MAX + 1):
    if dp[i - 1][v] == 0:
      continue
    plus = v + numbers[i]
    minus = v - numbers[i]
    if 0 <= plus <= MAX:
      dp[i][plus] += dp[i - 1][v]
    if 0 <= minus <= MAX:
      dp[i][minus] += dp[i - 1][v]

print(dp[N - 2][numbers[-1]])