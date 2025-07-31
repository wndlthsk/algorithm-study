from itertools import product
N, M = map(int, input().split())

seq = list(map(int, input().split()))

for p in product(sorted(seq), repeat=M):
  print(*p)