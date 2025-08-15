from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

dir = [[-1,-1], [-1, 1], [-1, 0], [0, 1], [0, -1], [1, -1], [1, 1], [1, 0]]

def bfs(x, y):
  visited = [[False] * M for _ in range(N)]
  q = deque()
  visited[x][y] = True
  q.append((x, y, 0))
  
  while q:
    x, y, distance = q.popleft()
    if board[x][y] == 1:
      return distance
    
    for dx, dy in dir:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
        visited[nx][ny] = True
        q.append((nx, ny, distance + 1))

max_val = 0
for i in range(N):
  for j in range(M):
    max_val = max(max_val, bfs(i, j))
print(max_val)