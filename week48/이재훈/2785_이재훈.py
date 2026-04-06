import sys
input = sys.stdin.readline

n = int(input())
chains = list(map(int, input().split()))

chains.sort()

need = n - 1
res = 0
for x in chains:
  if need <= 0:
    break

  use = min(x, need)
  need -= use
  res += use
  need -= 1
print(res)