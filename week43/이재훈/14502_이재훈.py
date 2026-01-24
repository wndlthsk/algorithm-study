from collections import deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

empty = []
virus = []

for i in range(N):
  for j in range(M):
    if board[i][j] == 0:
      empty.append((i, j))
    elif board[i][j] == 2:
      virus.append((i, j))

def spread_and_count():
  q = deque(virus)
  infected = []

  while q:
    x, y = q.popleft()
    for dx, dy in d:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < M:
        if board[nx][ny] == 0:
          board[nx][ny] = 2
          infected.append((nx, ny))
          q.append((nx, ny))

  safe = 0
  for i in range(N):
    for j in range(M):
      if board[i][j] == 0:
        safe += 1

  for x, y in infected:
    board[x][y] = 0

  return safe

ans = 0
L = len(empty)

for i in range(L):
  for j in range(i + 1, L):
    for k in range(j + 1, L):
      x1, y1 = empty[i]
      x2, y2 = empty[j]
      x3, y3 = empty[k]

      board[x1][y1] = 1
      board[x2][y2] = 1
      board[x3][y3] = 1

      ans = max(ans, spread_and_count())

      board[x1][y1] = 0
      board[x2][y2] = 0
      board[x3][y3] = 0

print(ans)
