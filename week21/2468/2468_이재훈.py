from collections import deque
N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]

MAX = 0
for i in range(N):
  MAX = max(max(board[i]), MAX)

can_go = [[0, 1], [0, -1], [1, 0], [-1, 0]]

def bfs(x, y, h, visited):
  q = deque()
  q.append((x, y))
  visited[x][y] = True
  
  while q:
    x, y = q.popleft()
    visited[x][y] = True
    
    for dx, dy in can_go:
      nx, ny = x + dx, y + dy
      if 0 <= nx <= N-1 and 0 <= ny <= N-1:
        if not visited[nx][ny] and board[nx][ny] > h:
          visited[nx][ny] = True
          q.append((nx, ny))

max_safe_area_cnt = 0
for h in range(0, MAX): # 비가 0부터 MAX-1까지 옴.
  visited = [[False] * N for _ in range(N)]
  safe_area_cnt = 0

  for i in range(N):
    for j in range(N):
      if not visited[i][j] and board[i][j] > h:
        bfs(i, j, h, visited)
        safe_area_cnt += 1

  max_safe_area_cnt = max(max_safe_area_cnt, safe_area_cnt)

print(max_safe_area_cnt)