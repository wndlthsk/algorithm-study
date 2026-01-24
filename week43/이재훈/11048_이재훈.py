from collections import deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

d = [(0, 1), (1, 0), (1, 1)]

dp = [[-1] * M for _ in range(N)]
dp[0][0] = board[0][0]

q = deque([(0, 0)])

while q:
  x, y = q.popleft()
  for dx, dy in d:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < M:
      new_val = dp[x][y] + board[nx][ny]
      if dp[nx][ny] < new_val:
        dp[nx][ny] = new_val
        q.append((nx, ny))

print(dp[N - 1][M - 1])