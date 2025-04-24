import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(i, j):
    q = deque([(i, j)])
    visited[i][j] = 1
    area = 1

    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0<=nx<n and 0<=ny<m and visited[nx][ny] == 0:
                if paint[nx][ny] == 1:
                    visited[nx][ny] = 1
                    area += 1
                    q.append((nx, ny))


    return area


n, m = map(int, sys.stdin.readline().split())
paint = []
for _ in range(n):
    paint.append(list(map(int, sys.stdin.readline().split())))

# print(paint)
visited = [[0] * m for _ in range(n)]
areas = []
for i in range(n):
    for j in range(m):
        if visited[i][j] == 0 and paint[i][j] == 1:
            areas.append(bfs(i, j))

print(len(areas))
if areas:
    print(max(areas))
else:
    print(0)