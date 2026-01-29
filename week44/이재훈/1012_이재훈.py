from collections import deque
T = int(input())

DIR = [(-1, 0), (1, 0), (0, -1), (0, 1)] # (dy, dx)

def bfs(r, c, visited):
  q = deque([(r, c)])
  visited[r][c] = True
  
  while q:
    y, x = q.popleft()
    for dy, dx in DIR:
      ny, nx = y + dy, x + dx
      if 0 <= ny < N and 0 <= nx < M:
        if not visited[ny][nx] and board[ny][nx] == 1:
          visited[ny][nx] = True
          q.append((ny, nx))

for _ in range(T):
  M, N, K = list(map(int, input().split()))
  board = [[0] * M for _ in range(N)]
  for _ in range(K):
    X, Y = map(int, input().split())
    board[Y][X] = 1
  
  cnt = 0
  visited = [[False] * M for _ in range(N)]
  for r in range(N):
    for c in range(M):
      if board[r][c] == 1 and not visited[r][c]:
        bfs(r, c, visited)
        cnt += 1
  
  print(cnt)