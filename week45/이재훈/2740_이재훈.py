N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
_, K = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(M)]

res = []
for i in range(N):
  line = []
  for j in range(K):
    s = 0
    for k in range(M):
      s += A[i][k] * B[k][j]
    line.append(s)
  res.append(line)

for l in res:
  print(*l)