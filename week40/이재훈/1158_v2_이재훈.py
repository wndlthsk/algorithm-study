N, K = map(int, input().split())

people = list(range(1, N + 1))
res = []
idx = 0
for step in range(N):
  idx = (idx + K - 1) % (N - step)
  res.append(people.pop(idx))

print(f"<{', '.join(map(str, res))}>")