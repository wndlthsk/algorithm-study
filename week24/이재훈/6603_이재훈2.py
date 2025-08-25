from itertools import combinations

while True:
  line = list(map(int, input().split()))
  if line[0] == 0:
    break
  k, S = line[0], line[1:]
  
  for comb in combinations(S, 6):
    print(*comb)
  print()