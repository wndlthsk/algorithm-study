from collections import deque
N = int(input())
board = [list(map(int, input())) for _ in range(N)]

direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]

def bfs(visited, x, y):
  q = deque([(x, y)])
  visited[x][y] = True
  cnt = 1
  while q:
    x, y = q.popleft()
    for dx, dy in direction:
      nx, ny = dx + x, dy + y
      if 0 <= nx < N and 0 <= ny < N:
        if not visited[nx][ny] and board[nx][ny] == 1:
          cnt += 1
          q.append((nx, ny))
          visited[nx][ny] = True
  return cnt

visited = [[False] * N for _ in range(N)]
res = []
for i in range(N):
  for j in range(N):
    if board[i][j] == 1 and not visited[i][j]:
      cnt = bfs(visited, i, j)
      res.append(cnt)

print(len(res))
for x in sorted(res):
  print(x)
