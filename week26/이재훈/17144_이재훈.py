R, C, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]

for i in range(R):
  if board[i][0] == -1:
    top, bottom = i, i + 1
    break

def move_dust(board):
  t = [[0] * C for _ in range(R)]
  for r in range(R):
    for c in range(C):
      if board[r][c] > 0:
        amount = board[r][c] // 5
        possible_dir = 0
        for dx, dy in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
          nx, ny = r + dx, c + dy
          if 0 <= nx < R and 0 <= ny < C and board[nx][ny] != -1:
            possible_dir += 1
            t[nx][ny] += amount
        board[r][c] -= amount * possible_dir
  for r in range(R):
    for c in range(C):
      board[r][c] += t[r][c]
  return board

def move_air(board, top, bottom):
  # 위쪽 (반시계)
  for r in range(top-1, 0, -1):
    board[r][0] = board[r-1][0]
  for c in range(C-1):
    board[0][c] = board[0][c+1]
  for r in range(top):
    board[r][C-1] = board[r+1][C-1]
  for c in range(C-1, 1, -1):
    board[top][c] = board[top][c-1]
  board[top][1] = 0

  # 아래쪽 (시계)
  for r in range(bottom+1, R-1):
    board[r][0] = board[r+1][0]
  for c in range(C-1):
    board[R-1][c] = board[R-1][c+1]
  for r in range(R-1, bottom, -1):
    board[r][C-1] = board[r-1][C-1]
  for c in range(C-1, 1, -1):
    board[bottom][c] = board[bottom][c-1]
  board[bottom][1] = 0
  
  return board

next_board = board[:]
for i in range(T):
  tmp = move_dust(next_board)
  next_board = move_air(tmp, top, bottom)
dust_in_room = sum(sum(row) for row in next_board) + 2
print(dust_in_room)