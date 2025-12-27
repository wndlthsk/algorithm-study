N, K = map(int, input().split())

people = list(range(1, N + 1))
idx = 0

res = []
for _ in range(1, N + 1):
  idx = (idx + K - 1) % len(people)
  out = people.pop(idx)
  res.append(out)
print(f"<{', '.join(map(str, res))}>")