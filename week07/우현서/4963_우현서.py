import sys
from collections import deque

# 상, 하, 좌, 우, 상좌, 상우, 하좌, 하우
dx = [0, 0, -1, 1, -1, -1, 1, 1]
dy = [-1, 1, 0, 0, -1, 1, -1, 1]

def bfs(i, j, visited): # i: y, j: x
    q = deque([(i, j)])
    visited[i][j] = 1

    while q:
        x, y = q.popleft()
        for d in range(8):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < h and 0 <= ny < w and visited[nx][ny] == 0:
                if board[nx][ny] == 1:
                    visited[nx][ny] = 1
                    q.append((nx, ny))

while True:
    w, h = map(int, sys.stdin.readline().split())
    if w == 0 and h == 0:
        break
    board = []
    for _ in range(h):
        board.append(list(map(int, sys.stdin.readline().split())))

    visited = [[0] * w for _ in range(h)]
    count = 0
    for i in range(h):
        for j in range(w):
            if visited[i][j] == 0 and board[i][j] == 1:
                bfs(i, j, visited)
                count += 1
    print(count)