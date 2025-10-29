import sys
sys.setrecursionlimit(10**6)

# dp[a][b][c] for 0<=a,b,c<=20
dp = [[[0]*21 for _ in range(21)] for __ in range(21)]

# 기저: a<=0 or b<=0 or c<=0 → 1
for a in range(21):
  for b in range(21):
    dp[a][b][0] = 1
    dp[a][0][b] = 1
for b in range(21):
  for c in range(21):
    dp[0][b][c] = 1

for a in range(1, 21):
  for b in range(1, 21):
    for c in range(1, 21):
      if a < b < c:
        dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c]
      else:
        dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1]

def w(a, b, c):
  if a <= 0 or b <= 0 or c <= 0:
    return 1
  
  if a > 20 or b > 20 or c > 20:
    return dp[20][20][20]
  
  return dp[a][b][c]

while True:
  a, b, c = map(int, input().split())
  if a == b == c == -1: break
  
  print(f"w({a}, {b}, {c}) = {w(a, b, c)}")