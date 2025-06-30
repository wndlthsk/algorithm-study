from collections import deque

N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

# 8방향 이동 (상,하,좌,우 + 대각선)
directions = [(-1,0), (1,0), (0,-1), (0,1), (-1,-1), (-1,1), (1,-1), (1,1)]

# 거리 저장 배열
distance = [[-1] * M for _ in range(N)]

# BFS 초기화: 상어가 있는 위치를 모두 큐에 추가
q = deque()
for i in range(N):
  for j in range(M):
    if board[i][j] == 1:
      q.append((i, j))
      distance[i][j] = 0  # 자기 자신은 거리 0

# BFS 실행
while q:
  x, y = q.popleft()
  for dx, dy in directions:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < M and distance[nx][ny] == -1:
      distance[nx][ny] = distance[x][y] + 1
      q.append((nx, ny))

# 결과: dist에서 최댓값을 찾음
max_dist = max(max(row) for row in distance)
print(max_dist)