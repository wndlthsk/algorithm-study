colors = set()

for _ in range(2):
  a, b = input().split()
  colors.add(a)
  colors.add(b)

colors = sorted(colors)

for c1 in colors:
  for c2 in colors:
    print(c1, c2)