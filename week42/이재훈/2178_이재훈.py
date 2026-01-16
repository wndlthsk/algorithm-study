from collections import deque
N, M = map(int, input().split())
board = [list(map(int, input())) for _ in range(N)]

def bfs():
  visited = [[False] * M for _ in range(N)]
  q = deque([(0, 0, 1)])
  visited[0][0] = True
  
  while q:
    x, y, cnt = q.popleft()
    if x == M - 1 and y == N - 1:
      return cnt
    
    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
      nx, ny = x + dx, y + dy
      if 0 <= nx <= M - 1 and 0 <= ny <= N - 1:
        if not visited[ny][nx] and board[ny][nx] == 1:
          visited[ny][nx] = True
          q.append((nx, ny, cnt + 1))
  return -1

print(bfs())