R, C = map(int, input().split())
board = [list(input()) for _ in range(R)]

dirs = [(-1,0),(1,0),(0,-1),(0,1)]
to_sink = []

for i in range(R):
  for j in range(C):
    if board[i][j] == 'X':
      sea = 0
      for dx, dy in dirs:
        nx, ny = i + dx, j + dy
        if nx < 0 or nx >= R or ny < 0 or ny >= C or board[nx][ny] == '.':
          sea += 1
      if sea >= 3:
        to_sink.append((i, j))

for x, y in to_sink:
  board[x][y] = '.'

min_r, max_r = R, 0
min_c, max_c = C, 0
for i in range(R):
  for j in range(C):
    if board[i][j] == 'X':
      min_r = min(min_r, i)
      max_r = max(max_r, i)
      min_c = min(min_c, j)
      max_c = max(max_c, j)

for i in range(min_r, max_r + 1):
  print(''.join(board[i][min_c:max_c + 1]))