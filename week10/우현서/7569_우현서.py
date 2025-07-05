# 익은 토마토가 6방향에 영향 줌
# 모든 토마토가 익는 최소 일수
# m x n x h
# 1: 익음, 0: 안익음, -1: 빈칸

import sys
from collections import deque

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, -1, 1]
def bfs(queue, visited, count):
    max_day = 0 # 익는데 가장 오래 걸린 토마토의 일수를 구해야함
    while queue:
        z, x, y, day = queue.popleft()
        max_day = max(max_day, day)
        for d in range(6):
            nx, ny, nz =  x + dx[d], y + dy[d], z + dz[d]
            if 0<=nx <n and 0<=ny<m and 0<=nz<h:
                if not visited[nz][nx][ny] and boxes[nz][nx][ny] == 0:
                    boxes[nz][nx][ny] = 1
                    count -= 1
                    visited[nz][nx][ny] = True
                    queue.append((nz, nx, ny, day + 1))
    return max_day, count


m, n, h = map(int, sys.stdin.readline().split())
boxes = [[] for _ in range(h)]
tomatoes = deque()
visited = [[[False] * m for _ in range(n)] for _ in range(h)]
count = 0 # 안 익은 토마토

for i in range(h):
    for j in range(n): # 세로, x
        tmp = list(map(int, sys.stdin.readline().split())) # 가로, y
        for k in range(m):
            if tmp[k] == 1:
                tomatoes.append((i, j, k, 0))
                visited[i][j][k] = True
            elif tmp[k] == 0:
                count += 1
        boxes[i].append(tmp)
# print(boxes)
# print(tomatoes)
# print(visited)
result, count = bfs(tomatoes, visited, count)

if count == 0:
    print(result)
else:
    print(-1)