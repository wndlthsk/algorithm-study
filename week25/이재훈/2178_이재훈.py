from collections import deque
N, M = map(int, input().split())
board = [list(map(int,list(input()))) for _ in range(N)]

dict = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(x, y):
  visited = [[False] * (M + 1) for _ in range(N + 1)]
  q = deque()
  visited[x][y] = True
  q.append((x, y, 1))
  
  while q:
    x, y, cnt = q.popleft()
    
    if x == N and y == M:
      return cnt
    
    for dx, dy in dict:
      nx, ny = x + dx, y + dy
      if 1 <= nx <= N and 1 <= ny <= M:
        if board[nx - 1][ny - 1] == 0:
          continue
        if not visited[nx][ny]:
          visited[nx][ny] = True
          q.append((nx, ny, cnt + 1))
  return -1
print(bfs(1, 1))