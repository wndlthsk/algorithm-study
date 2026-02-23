from collections import deque

DIR = [(1, 0), (-1, 0), (0, 1), (0, -1),
       (1, 1), (1, -1), (-1, -1), (-1, 1)]

def bfs(row, col, visited, board, h, w):
  visited[row][col] = True
  q = deque([(row, col)])
  
  while q:
    r, c = q.popleft()
    for dr, dc in DIR:
      nr, nc = r + dr, c + dc
      if 0 <= nr < h and 0 <= nc < w:
        if not visited[nr][nc] and board[nr][nc] == 1:
          visited[nr][nc] = True
          q.append((nr, nc))

while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break
  
  board = [list(map(int, input().split())) for _ in range(h)]
  visited = [[False] * w for _ in range(h)]
  
  cnt = 0
  for row in range(h):
    for col in range(w):
      if not visited[row][col] and board[row][col] == 1:
        bfs(row, col, visited, board, h, w)
        cnt += 1
  
  print(cnt)