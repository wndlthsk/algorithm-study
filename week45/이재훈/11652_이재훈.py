import sys
input = sys.stdin.readline

N = int(input())
numbers = [int(input()) for _ in range(N)]

d = {}
for x in numbers:
  d[x] = d.get(x, 0) + 1
srt = sorted(d.items(), key=lambda x: (-x[1], x[0]))
print(srt[0][0])