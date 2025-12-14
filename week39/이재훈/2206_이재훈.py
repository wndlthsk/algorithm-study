from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(N)]

visited = [[[0]*2 for _ in range(M)] for _ in range(N)]

directions = [
  (1, 0),
  (-1, 0),
  (0, 1),
  (0, -1),
]

q = deque()
q.append((0, 0, 0))  # x, y, break_used
visited[0][0][0] = 1

while q:
  x, y, broken = q.popleft()

  if x == N-1 and y == M-1:
    print(visited[x][y][broken])
    exit()

  for dx, dy in directions:
    nx, ny = x + dx, y + dy

    if 0 <= nx < N and 0 <= ny < M:
      if board[nx][ny] == 0 and visited[nx][ny][broken] == 0:
        visited[nx][ny][broken] = visited[x][y][broken] + 1
        q.append((nx, ny, broken))

      elif board[nx][ny] == 1 and broken == 0 and visited[nx][ny][1] == 0:
        visited[nx][ny][1] = visited[x][y][broken] + 1
        q.append((nx, ny, 1))

print(-1)
