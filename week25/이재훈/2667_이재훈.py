from collections import deque
N = int(input())
board = [list(map(int, list(input()))) for _ in range(N)]

dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

visited = [[False] * N for _ in range(N)]
def bfs(x, y):
  q = deque()
  visited[x][y] = True
  q.append((x, y))
  size = 1
  
  while q:
    x, y = q.popleft()
    
    for dx, dy in dirs:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < N:
        if board[nx][ny] == 0:
          continue
        if not visited[nx][ny]:
          visited[nx][ny] = True
          q.append((nx, ny))
          size += 1
  return size

res = []
for i in range(N):
  for j in range(N):
    if board[i][j] == 1 and not visited[i][j]:
      cnt = bfs(i, j)
      res.append(cnt)
print(len(res))
for x in sorted(res):
  print(x)