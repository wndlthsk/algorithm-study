from collections import deque
N = int(input())
r1, c1, r2, c2 = map(int, input().split())

dirt = [(-2, -1), (-2, 1), (0, -2), (0, 2), (2, -1), (2, 1)]
visited = [[False] * N for _ in range(N)]
visited[r1][c1] = True
q = deque([(r1, c1, 0)])
while q:
  x, y, cnt = q.popleft()
  if x == r2 and y == c2:
    print(cnt)
    exit()
  for dx, dy in dirt:
    nx, ny = x + dx, y + dy
    if 0 <= nx < N and 0 <= ny < N:
      if not visited[nx][ny]:
        visited[nx][ny] = True
        q.append((nx, ny, cnt + 1))

print(-1)