from collections import deque
M, N, H = map(int, input().split())
board = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

d = [(1,0,0), (-1,0,0), (0,1,0), (0,-1,0), (0,0,1), (0,0,-1)]

q = deque()

# 1️⃣ 모든 익은 토마토를 큐에 넣기
for z in range(H):
  for x in range(N):
    for y in range(M):
      if board[z][x][y] == 1:
        q.append((z, x, y))

# 2️⃣ BFS
while q:
  z, x, y = q.popleft()

  for dz, dx, dy in d:
    nz, nx, ny = z + dz, x + dx, y + dy
    if 0 <= nz < H and 0 <= nx < N and 0 <= ny < M:
      if board[nz][nx][ny] == 0:
        board[nz][nx][ny] = board[z][x][y] + 1
        q.append((nz, nx, ny))

# 3️⃣ 결과 계산
ans = 0
for z in range(H):
  for x in range(N):
    for y in range(M):
      if board[z][x][y] == 0:
        print(-1)
        exit()
      ans = max(ans, board[z][x][y])

print(ans - 1)