N, M = map(int, input().split())
if N == 0:
  print(0)
  exit()
weights = list(map(int, input().split()))

cnt = 1
cur = 0
for w in weights:
  if cur + w <= M:
    cur += w
  else:
    cur = w
    cnt += 1
print(cnt)