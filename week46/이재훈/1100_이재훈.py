board = [list(input()) for _ in range(8)]

cnt = 0
for row in range(8):
  for col in range(8):
    is_white = (row + col) % 2 == 0
    if is_white and board[row][col] == 'F':
      cnt += 1
print(cnt)