N = int(input())
AgeName = [input().split() for _ in range(N)]

srt = sorted(AgeName, key=lambda x: int(x[0]))

for pack in srt:
  print(*pack)
