N, M = map(int, input().split())

paper = [[0] * 100 for _ in range(100)]
for _ in range(N):
  start_x, start_y, end_x, end_y = map(int, input().split())
  for y in range(start_y - 1, end_y):
    for x in range(start_x - 1, end_x):
      paper[y][x] += 1

cnt = 0
for p in paper:
  for x in p:
    if x > M:
      cnt += 1
print(cnt)