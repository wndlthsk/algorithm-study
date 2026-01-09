import sys
input = sys.stdin.readline
N = int(input())

res = []
for _ in range(N):
  digit = int(input())
  res.append(digit)
print('\n'.join(map(str, sorted(res))))