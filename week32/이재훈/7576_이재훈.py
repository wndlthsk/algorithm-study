from collections import deque
M, N = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
q = deque()

for i in range(N):
  for j in range(M):
    if board[i][j] == 1:
      q.append((i, j))

while q:
  x, y = q.popleft()
  for dx, dy in d:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < M:
      if board[nx][ny] == 0:
        board[nx][ny] = board[x][y] + 1
        q.append((nx, ny))

res = 0
for row in board:
  for value in row:
    if value == 0:
      print(-1)
      exit(0)
  res = max(res, max(row))

print(res - 1)