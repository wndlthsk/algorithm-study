N, M = map(int, input().split())
buckets = list(range(1, N + 1))

for _ in range(M):
  i, j = map(int, input().split())
  buckets = buckets[:i-1] + buckets[i-1:j][::-1] + buckets[j:]
print(*buckets)