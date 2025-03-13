import sys

d, k = map(int, sys.stdin.readline().split())

dp = [(0, 0)] * 31
dp[1] = (1, 0)
dp[2] = (0, 1)
for i in range(3, d+1):
    dp[i] = (dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1])


a = dp[d][0]
b = dp[d][1]
x, y = 1, 1
for x in range(1, k // a):
    if (k - a * x) % b == 0:
      y = (k - a * x) // b
      if x <= y:
          break

print(x)
print(y)