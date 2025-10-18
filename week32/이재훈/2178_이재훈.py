from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def bfs(x, y):
  q = deque([(x, y, 1)])
  visited = [[False] * M for _ in range(N)]
  visited[x][y] = True
  
  while q:
    x, y, cnt = q.popleft()
    if x == N - 1 and y == M - 1:
      return cnt
    
    for dx, dy in d:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < M:
        if not visited[nx][ny] and board[nx][ny] == 1:
          q.append((nx, ny, cnt + 1))
          visited[nx][ny] = True

print(bfs(0, 0))