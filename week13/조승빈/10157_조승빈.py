C, R = map(int, input().split())
K = int(input())

if K > C * R:
    print(0)
    exit()

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
vis = [[False] * C for _ in range(R)]

x, y, dir = 0, 0, 0
for i in range(1, K):
    vis[y][x] = True
    nx = x + dx[dir]
    ny = y + dy[dir]
    if 0 <= nx < C and 0 <= ny < R and not vis[ny][nx]:
        x, y = nx, ny
    else:
        dir = (dir + 1) % 4
        x += dx[dir]
        y += dy[dir]

print(x + 1, y + 1)
