N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]

srt = sorted(lst, key=lambda x: (x[1], x[0]))
for x, y in srt:
  print(x, y)