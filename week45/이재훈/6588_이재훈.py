import sys

MAX = 1_000_000

dp = [True] * (MAX + 1)
dp[0] = False
dp[1] = False

for i in range(2, int(MAX ** 0.5) + 1):
  if dp[i]:
    for j in range(i * i, MAX + 1, i):
      dp[j] = False

for line in sys.stdin:
  n = int(line)
  if n == 0:
    break
  
  is_valid = False
  for i in range(3, n // 2 + 1, 2):
    if dp[i] and dp[n - i]:
      is_valid = True
      print(f"{n} = {i} + {n - i}")
      break
  
  if not is_valid:
    print("Goldbach's conjecture is wrong.")