from itertools import combinations

while True:
  kNum_raws = list(map(int, input().split()))

  if kNum_raws[0] == 0:
    break
  
  for comb in combinations(kNum_raws[1:], 6):
    print(*comb)
  print()