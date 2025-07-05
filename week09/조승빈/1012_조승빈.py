from collections import deque


dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x, y, field, visited, M, N):
    queue = deque()
    queue.append((x, y))
    visited[y][x] = True

    while queue:
        cx, cy = queue.popleft()
        for dir in range(4):
            nx = cx + dx[dir]
            ny = cy + dy[dir]
            if 0 <= nx < M and 0 <= ny < N:
                if field[ny][nx] == 1 and not visited[ny][nx]:
                    visited[ny][nx] = True
                    queue.append((nx, ny))

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    field = [[0]*M for _ in range(N)]
    visited = [[False]*M for _ in range(N)]
    
    for _ in range(K):
        x, y = map(int, input().split())
        field[y][x] = 1  
    worm_count = 0
    for y in range(N):
        for x in range(M):
            if field[y][x] == 1 and not visited[y][x]:
                bfs(x, y, field, visited, M, N)
                worm_count += 1
    print(worm_count)
