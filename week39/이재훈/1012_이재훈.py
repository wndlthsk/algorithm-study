import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

T = int(input())

def dfs(x, y):
  visited[x][y] = True

  for dx, dy in [(-1,0), (1,0), (0,-1), (0,1)]:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < M:
      if not visited[nx][ny] and board[nx][ny] == 1:
        dfs(nx, ny)

for _ in range(T):
  M, N, K = map(int, input().split())

  board = [[0] * M for _ in range(N)]
  visited = [[False] * M for _ in range(N)]

  for _ in range(K):
    y, x = map(int, input().split())
    board[x][y] = 1

  worm = 0
  for i in range(N):
    for j in range(M):
      if board[i][j] == 1 and not visited[i][j]:
        dfs(i, j)
        worm += 1

  print(worm)
