import sys
input = sys.stdin.readline

N = int(input())
Xi = list(map(int, input().split()))

srt = sorted(set(Xi))
d = {v:i for i, v in enumerate(srt)}

res = []
for x in Xi:
  res.append(d[x])
print(*res)