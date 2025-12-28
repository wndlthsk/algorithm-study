N, M = map(int, input().split())

bucket = [0] * N
for _ in range(M):
  i, j, k = map(int, input().split())
  for x in range(i, j + 1):
    bucket[x - 1] = k
print(*bucket)