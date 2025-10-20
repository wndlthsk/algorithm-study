from collections import deque
import sys
sys.setrecursionlimit(10**6)

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

d = [(0, 1), (0, -1), (1, 0), (-1, 0)]

def dfs(x, y, island_num):
  visited[x][y] = True
  board[x][y] = island_num
  for dx, dy in d:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < N:
      if not visited[nx][ny] and board[nx][ny] == 1:
        dfs(nx, ny, island_num)

def bfs(island_num):
  q = deque()
  dist = [[-1] * N for _ in range(N)]
  
  # 현재 섬의 모든 육지 좌표 큐에 삽입
  for i in range(N):
    for j in range(N):
      if board[i][j] == island_num:
        for dx, dy in d:
          nx, ny = i + dx, j + dy
          if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0:
            q.append((i, j))
            dist[i][j] = 0
            break
  
  # BFS로 바다를 따라 다른 섬까지 확장
  while q:
    x, y = q.popleft()
    for dx, dy in d:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < N:
        # 다른 섬 도착
        if board[nx][ny] != 0 and board[nx][ny] != island_num:
          return dist[x][y]
        # 바다이면서 아직 방문 안 한 칸
        if board[nx][ny] == 0 and dist[nx][ny] == -1:
          dist[nx][ny] = dist[x][y] + 1
          q.append((nx, ny))
  return float('inf')  # 연결 불가능할 경우 큰 값 반환

visited = [[False] * N for _ in range(N)]
island_num = 2
for i in range(N):
  for j in range(N):
    if not visited[i][j] and board[i][j] == 1:
      dfs(i, j, island_num)
      island_num += 1

ans = float('inf')
for i in range(2, island_num):
  ans = min(ans, bfs(i))

print(ans)