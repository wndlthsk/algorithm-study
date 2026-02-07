N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
_, K = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(M)]

res = []
for row in range(N):
  line = []
  for col in range(K):
    tmp = 0
    for mid in range(M):
      tmp += A[row][mid] * B[mid][col]
    line.append(tmp)
  res.append(line)

for l in res:
  print(*l)