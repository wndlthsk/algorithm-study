import sys
input = sys.stdin.readline

R, C = map(int, input().split())
board = [list(input().strip()) for _ in range(R)]

dirs = [(-1,0),(1,0),(0,-1),(0,1)]

for i in range(R):
  for j in range(C):
    if board[i][j] == 'W':
      for dx, dy in dirs:
        ni, nj = i + dx, j + dy
        if 0 <= ni < R and 0 <= nj < C:
          if board[ni][nj] == 'S':
            print(0)
            exit()

print(1)
for i in range(R):
  for j in range(C):
    if board[i][j] == '.':
      board[i][j] = 'D'

for row in board:
  print(''.join(row))