MAX = 10_000

def d(n):
  return n + sum(map(int, str(n)))

s = set()
for i in range(1, MAX + 1):
  s.add(d(i))

for x in range(1, MAX + 1):
  if x not in s:
    print(x)