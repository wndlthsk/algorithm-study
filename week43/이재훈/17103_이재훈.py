import sys
input = sys.stdin.readline

MAX = 1_000_000
stg = [True] * (MAX + 1)
stg[0] = False
stg[1] = False
for i in range(2, int(MAX ** 0.5) + 1):
  if stg[i]:
    for j in range(i * i, MAX + 1, i):
      if j % i == 0:
        stg[j] = False

T = int(input())
for _ in range(T):
  N = int(input())
  
  cnt = 0
  for x in range(2, N // 2 + 1):
    if stg[x] and stg[N - x]:
      cnt += 1
  print(cnt)