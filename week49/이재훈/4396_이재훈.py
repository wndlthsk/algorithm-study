import sys
input = sys.stdin.readline

N = int(input())
board = [list(input().strip()) for _ in range(N)]
click = [list(input().strip()) for _ in range(N)]

dx = [-1,-1,-1,0,0,1,1,1]
dy = [-1,0,1,-1,1,-1,0,1]

def count_mine(x, y):
  cnt = 0
  for d in range(8):
    nx = x + dx[d]
    ny = y + dy[d]
    if 0 <= nx < N and 0 <= ny < N:
      if board[nx][ny] == '*':
        cnt += 1
  return cnt

result = [['.' for _ in range(N)] for _ in range(N)]
exploded = False

for i in range(N):
  for j in range(N):
    if click[i][j] == 'x':
      if board[i][j] == '*':
        exploded = True
      else:
        result[i][j] = str(count_mine(i, j))

if exploded:
  for i in range(N):
    for j in range(N):
      if board[i][j] == '*':
        result[i][j] = '*'

for row in result:
  print(''.join(row))