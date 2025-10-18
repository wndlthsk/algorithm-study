N, M = map(int, input().split())

seq = list(range(1, N + 1))
for _ in range(M):
  start, end = list(map(int, input().split()))
  seq[start - 1:end] = seq[start - 1:end][::-1]
print(*seq)