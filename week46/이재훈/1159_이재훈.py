N = int(input())
players = [input() for _ in range(N)]

first_name = [player[0] for player in players]

freq = {}
for name in first_name:
  freq[name] = freq.get(name, 0) + 1

res = [n for n, cnt in freq.items() if cnt >= 5]
if res:
  print(''.join(sorted(res)))
else:
  print("PREDAJA")