N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
B = [list(map(int, input().split())) for _ in range(N)]

res = []
for a, b in zip(A, B):
  line = []
  for x, y in zip(a, b):
    line.append(x + y)
  res.append(line)

for l in res:
  print(*l)