N = int(input())
score = []
for _ in range(N):
  l = input().split()
  score.append(l[:1] + list(map(int, l[1:])))

srt = sorted(score, key=lambda x: (-x[1], x[2], -x[3], x[0]))

for pack in srt:
  print(pack[0])