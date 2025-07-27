from collections import deque

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
max_safe = 0

def bfs(temp_board):
  q = deque()
  for i in range(N):
    for j in range(M):
      if temp_board[i][j] == 2:
        q.append((i, j))
  
  while q:
    x, y = q.popleft()
    
    for d in range(4):
      nx = x + dx[d]
      ny = y + dy[d]
      if 0 <= nx < N and 0 <= ny < M and temp_board[nx][ny] == 0:
        temp_board[nx][ny] = 2
        q.append((nx, ny))
  
  safe = sum(row.count(0) for row in temp_board)
  return safe

def build_walls(count):
  global max_safe
  if count == 3:
    temp_board = [row[:] for row in board] # deepcopy 대신 리스트 컴프리헨션으로 복사
    max_safe = max(max_safe, bfs(temp_board))
    return

  for i in range(N):
    for j in range(M):
      if board[i][j] == 0:
        board[i][j] = 1  # 벽 세우기
        build_walls(count + 1)
        board[i][j] = 0  # 벽 되돌리기 (백트래킹)

build_walls(0)
print(max_safe)