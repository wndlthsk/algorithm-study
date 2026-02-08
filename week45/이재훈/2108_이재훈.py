import sys
input = sys.stdin.readline
import math

N = int(input())
numbers = [int(input()) for _ in range(N)]

total = sum(numbers)
avg = total / N

d = {}
for x in numbers:
  d[x] = d.get(x, 0) + 1
srt = sorted(sorted(d), key=lambda x: d[x], reverse=True)

print(math.floor(avg + 0.5) if avg >= 0 else math.ceil(avg - 0.5))
print(sorted(numbers)[N // 2])
print(srt[1] if len(srt) > 1 and d[srt[0]] == d[srt[1]] else srt[0])
print(max(numbers) - min(numbers))