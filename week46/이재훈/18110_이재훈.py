import sys
input = sys.stdin.readline

n = int(input())
if n == 0:
  print(0)
  exit()

opinions = sorted(int(input()) for _ in range(n))

each = int(n * 0.15 + 0.5)

sep = opinions[each:n-each]
avg = int(sum(sep) / len(sep) + 0.5)

print(avg)