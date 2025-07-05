# 빨,초 를 같은 구역으로 봄
# 4방향

import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
def bfs(i, j, red_green):
    visited[i][j] = True
    queue = deque([(i, j)])

    while queue:
        x, y = queue.popleft()
        now = paint[x][y]
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0<=nx<n and 0<=ny<n and not visited[nx][ny]:
                if red_green:
                    if now in 'RG' and paint[nx][ny] in 'RG' or now == paint[nx][ny]:
                        visited[nx][ny] = True
                        queue.append((nx, ny))
                else:
                    if now == paint[nx][ny]:
                        visited[nx][ny] = True
                        queue.append((nx, ny))


n = int(sys.stdin.readline())
paint = []
for i in range(n):
    paint.append(list(sys.stdin.readline().rstrip()))
# print(paint)

count = 0
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, False)
            count += 1
print(count, end=' ')

visited = [[False] * n for _ in range(n)]
count2 = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            bfs(i, j, True)
            count2 += 1
print(count2)