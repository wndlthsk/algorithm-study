from itertools import permutations
N, M = map(int, input().split())

seq = list(map(int, input().split()))

upper_seq = sorted(seq)
for p in permutations(upper_seq, M):
  print(*p)