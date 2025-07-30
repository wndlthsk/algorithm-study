from itertools import combinations

N, M = map(int, input().split())

seq = list(map(int, input().split()))

for comb in combinations(sorted(seq), M):
  print(*comb)