N, binary = map(int, input().split())

p = 1
while binary ** p < N:
  p += 1

res = []
for i in range(p, 0, -1):
  cnt = 0
  if N >= binary ** (i - 1):
    N -= binary ** i
    cnt += 1
  res.append(cnt)

r = [ascii(107 - x) if x >= 10 else x for x in res]
print(r, sep='')