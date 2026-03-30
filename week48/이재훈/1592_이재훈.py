import sys
input = sys.stdin.readline

N, M, L = map(int, input().split())
cnt = [0] * N

cur = 0
throw = 0
while True:
  cnt[cur] += 1
  if cnt[cur] == M:
    print(throw)
    break

  if cnt[cur] % 2 == 1:
    cur = (cur + L) % N
  else:
    cur = (cur - L) % N

  throw += 1