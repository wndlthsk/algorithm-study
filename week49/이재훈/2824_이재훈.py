import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

M = int(input())
B = list(map(int, input().split()))

from collections import defaultdict

def factorize(x, d):
  i = 2
  while i * i <= x:
    while x % i == 0:
      d[i] += 1
      x //= i
    i += 1
  if x > 1:
    d[x] += 1

A_cnt = defaultdict(int)
B_cnt = defaultdict(int)

for a in A:
  factorize(a, A_cnt)

for b in B:
  factorize(b, B_cnt)

result = 1
MOD = 10**9
overflow = False

for p in A_cnt:
  if p in B_cnt:
    cnt = min(A_cnt[p], B_cnt[p])
    for _ in range(cnt):
      result *= p
      if result >= MOD:
        result %= MOD
        overflow = True

if overflow:
  print(str(result).zfill(9))
else:
  print(result)