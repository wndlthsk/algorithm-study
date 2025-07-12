from collections import deque

n = int(input())
r1, c1, r2, c2 = map(int, input().split())

nx =[-2,-2,0,0,2,2,]
ny = [-1,1,-2,2,-1,1]
graph = [[-1] * n for _ in range(n)]

queue = deque()
queue.append((r1, c1))
graph[r1][c1] = 0

while queue:
    x, y = queue.popleft()
    for i in range(6):
        nr, nc = x + nx[i], y + ny[i]
        if 0 <= nr < n and 0 <= nc < n and graph[nr][nc] == -1:
            graph[nr][nc] = graph[x][y] + 1
            queue.append((nr, nc))

print(graph[r2][c2])
