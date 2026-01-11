N, M = map(int, input().split())

poketmon = {}
rev_poketmon = {}
for i in range(1, N + 1):
  name = input()
  poketmon[i] = name
  rev_poketmon[name] = i

for _ in range(M):
  value = input()
  if value.isdigit():
    print(poketmon[int(value)])
  else:
    print(rev_poketmon[value])