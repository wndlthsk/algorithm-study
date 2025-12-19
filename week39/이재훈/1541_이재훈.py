expr = input()

parts = expr.split('-')

res = sum(map(int, parts[0].split('+')))
for p in parts[1:]:
  res -= sum(map(int, p.split('+')))

print(res)