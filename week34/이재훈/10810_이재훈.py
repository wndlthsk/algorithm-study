N, M = map(int, input().split())

res = [0] * (N + 1)
for _ in range(M):
  i, j, k = map(int, input().split())
  for idx in range(i, j + 1):
    res[idx] = k
print(*res[1:])