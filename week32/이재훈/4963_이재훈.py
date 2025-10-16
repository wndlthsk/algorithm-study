from collections import deque

def bfs(visited, x, y):
  q = deque([(x, y)])
  visited[x][y] = True
  
  while q:
    x, y = q.popleft()
    for dx, dy in d:
      nx, ny = x + dx, y + dy
      if 0 <= nx < h and 0 <= ny < w:
        if not visited[nx][ny] and board[nx][ny] == 1:
          q.append((nx, ny))
          visited[nx][ny] = True
  return 1

d = [(0, -1), (0, 1), (1, 0), (-1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]

while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break
  
  board = [list(map(int, input().split())) for _ in range(h)]
  visited = [[False] * w for _ in range(h)]
  cnt = 0
  for i in range(h):
    for j in range(w):
      if not visited[i][j] and board[i][j] == 1:
        cnt += bfs(visited, i, j)
  print(cnt)