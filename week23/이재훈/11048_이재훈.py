N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

# 메모이제이션 테이블
dp = [[-1] * M for _ in range(N)]

# 이동 방향: 오른쪽, 아래, 대각선
dirs = [(0, 1), (1, 0), (1, 1)]

def dfs(x, y):
  # 도착
  if x == N-1 and y == M-1:
    return board[x][y]
  
  if dp[x][y] != -1:  # 이미 계산된 값
    return dp[x][y]
  
  max_candy = 0
  for dx, dy in dirs:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < M:
      max_candy = max(max_candy, dfs(nx, ny))
  
  dp[x][y] = board[x][y] + max_candy
  return dp[x][y]
print(dfs(0, 0))