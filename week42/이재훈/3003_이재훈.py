TARGET = [1, 1, 2, 2, 2, 8]
line = list(map(int, input().split()))

res = []
for x, y in zip(TARGET, line):
  diff = x - y
  res.append(diff)
print(*res)
