N = int(input())
lines = list(set(input() for _ in range(N)))

lines.sort()
lines.sort(key=lambda x: len(x))

for x in lines:
  print(x)