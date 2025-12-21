N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

M, K = map(int, input().split())
B = [list(map(int, input().split())) for _ in range(M)]

# 결과 행렬 N x K
C = [[0] * K for _ in range(N)]

for i in range(N):
  for j in range(K):
    for t in range(M):
      C[i][j] += A[i][t] * B[t][j]

for row in C:
  print(*row)