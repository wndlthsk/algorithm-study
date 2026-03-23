from collections import deque

N = int(input())
board = [list(input()) for _ in range(N)]

start = []
end = []

for i in range(N):
  for j in range(N):
    if board[i][j] == 'B':
      start.append((i, j))
    if board[i][j] == 'E':
      end.append((i, j))

start.sort()
end.sort()

def get_state(log):
  (x1, y1), (x2, y2), (x3, y3) = log
  if x1 == x2 == x3:
    return x2, y2, 0
  else:
    return x2, y2, 1

sx, sy, sd = get_state(start)
ex, ey, ed = get_state(end)

visited = [[[0]*2 for _ in range(N)] for _ in range(N)]
visited[sx][sy][sd] = 1

q = deque()
q.append((sx, sy, sd, 0))

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def can_move(x, y, d):
  if d == 0:
    for ny in [y-1, y, y+1]:
      if not (0 <= x < N and 0 <= ny < N): return False
      if board[x][ny] == '1': return False
  else:
    for nx in [x-1, x, x+1]:
      if not (0 <= nx < N and 0 <= y < N): return False
      if board[nx][y] == '1': return False
  return True

def can_rotate(x, y):
  for i in range(x-1, x+2):
    for j in range(y-1, y+2):
      if not (0 <= i < N and 0 <= j < N): return False
      if board[i][j] == '1': return False
  return True

while q:
  x, y, d, cnt = q.popleft()

  if (x, y, d) == (ex, ey, ed):
    print(cnt)
    exit()

  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx < N and 0 <= ny < N:
      if can_move(nx, ny, d) and not visited[nx][ny][d]:
        visited[nx][ny][d] = 1
        q.append((nx, ny, d, cnt+1))

  nd = 1 - d
  if can_rotate(x, y) and not visited[x][y][nd]:
    visited[x][y][nd] = 1
    q.append((x, y, nd, cnt+1))

print(0)