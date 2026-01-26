import sys
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
M = int(input())
inner = list(map(int, input().split()))

OFFSET = 10000000
have = [0] * (2 * OFFSET + 1)

for x in numbers:
  have[x + OFFSET] = 1

res = []
for x in inner:
  res.append(have[x + OFFSET])
print(*res)
