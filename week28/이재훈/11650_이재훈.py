N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]

srt = sorted(lst, key=lambda x: (x[0], x[1]))
for pack in srt:
  print(*pack)