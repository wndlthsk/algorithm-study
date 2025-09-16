R, C, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]

top, bottom = 0, 0
for i in range(R):
  if board[i][0] == -1:
    top = i
    bottom = i + 1
    break

def dust(board):
  tmp = [[0] * C for _ in range(R)]
  for i in range(R):
    for j in range(C):
      if board[i][j] > 0:
        amount = board[i][j] // 5
        direction = 0
        for dx, dy in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
          nx, ny = i + dx, j + dy
          if 0 <= nx < R and 0 <= ny < C and board[nx][ny] != -1:
            tmp[nx][ny] += amount
            direction += 1
        board[i][j] -= amount * direction
  
  for i in range(R):
    for j in range(C):
      board[i][j] += tmp[i][j]
  return board

def air(board):
  for r in range(top - 1, 0, -1):
    board[r][0] = board[r - 1][0]
  for c in range(C - 1):
    board[0][c] = board[0][c + 1]
  for r in range(top):
    board[r][C - 1] = board[r + 1][C - 1]
  for c in range(C - 1, 1, -1):
    board[top][c] = board[top][c - 1]
  board[top][1] = 0
  
  for r in range(bottom + 1, R - 1):
    board[r][0] = board[r + 1][0]
  for c in range(C - 1):
    board[R - 1][c] = board[R - 1][c + 1]
  for r in range(R - 1, bottom, -1):
    board[r][C - 1] = board[r - 1][C - 1]
  for c in range(C - 1, 1, -1):
    board[bottom][c] = board[bottom][c - 1]
  board[bottom][1] = 0
  
  return board

res_board = board[:]
for i in range(T):
  res_board = dust(res_board)
  res_board = air(res_board)

res = sum(sum(row) for row in res_board)
print(res + 2)