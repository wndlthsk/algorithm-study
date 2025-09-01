from collections import deque
N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

def max2inArr(arr2):
  max_val = 0
  for i in range(N):
    for j in range(N):
      max_val = max(max_val, arr2[i][j])
  return max_val

dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]

def bfs(x, y, visited, h):
  q = deque()
  visited[x][y] = True
  q.append((x, y))
  
  while q:
    x, y = q.popleft()
    for dx, dy in dirs:
      nx, ny = x + dx, y + dy
      if (0 <= nx < N and 0 <= ny < N) and not visited[nx][ny]:
        if board[nx][ny] > h:
          visited[nx][ny] = True
          q.append((nx, ny))
  return 1

max_val = 0
for h in range(max2inArr(board) + 1):
  visited = [[False] * N for _ in range(N)]
  cnt = 0
  for i in range(N):
    for j in range(N):
      if not visited[i][j] and board[i][j] > h:
        cnt += bfs(i, j, visited, h)
  max_val = max(max_val, cnt)
print(max_val)