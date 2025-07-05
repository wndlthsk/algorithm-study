import sys
from collections import deque

def bfs(x, y, visited):
    q = deque()
    q.append((x, y))
    visited[x][y] = 1
    area = 1

    while q:
        i, j = q.popleft()
        for k in range(4):
            ni, nj = i + dx[k], j + dy[k]
            if 0 <= ni < m and 0 <= nj < n and visited[ni][nj] == 0:
                if paper[ni][nj] == 0:
                    visited[ni][nj] = 1
                    q.append((ni, nj))
                    area += 1
    return area


m, n, k = map(int, sys.stdin.readline().split())
paper = [[0] * n for _ in range(m)]
for i in range(k):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    for y in range(y1, y2):
        for x in range(x1, x2):
            paper[m-y-1][x] += 1


visited = [[0] * n for _ in range(m)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
areas = []
for i in range(m):
    for j in range(n):
        if paper[i][j] == 0 and visited[i][j] == 0:
            areas.append(bfs(i, j, visited))

areas.sort()
print(len(areas))
print(*areas)