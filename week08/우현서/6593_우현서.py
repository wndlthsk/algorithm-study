import sys
from collections import deque

dz = [0, 0, 0, 0, 1, -1]
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]

def bfs(s):
    queue = deque([(s[0], s[1], s[2], 0)]) # (층, 행, 열, 시간)
    visited[s[0]][s[1]][s[2]] = True

    while queue:
        z, x, y, time = queue.popleft()
        if building[z][x][y] == 'E':
            return time

        for d in range(6):
            nz = z + dz[d]
            nx = x + dx[d]
            ny = y + dy[d]
            if 0<=nz<l and 0<=nx<r and 0<=ny<c:
                if  visited[nz][nx][ny] is False and building[nz][nx][ny] != '#':
                    queue.append((nz, nx, ny, time + 1))
                    visited[nz][nx][ny] = True

    return -1


start = tuple()
while True:
    l, r, c = map(int, sys.stdin.readline().split())
    if l == 0:
        break
    building = []
    for i in range(l): # 층
        floor = []
        for j in range(r): # 행
            row = list(sys.stdin.readline().rstrip())
            for k in range(len(row)): # 열
                if row[k] == 'S':
                    start = (i, j, k) # 시작 지점 저장
            floor.append(row)
            # floor.append(list(sys.stdin.readline().rstrip()))
        building.append(floor)
        sys.stdin.readline()

    # print(building)
    # print(start)
    visited = [[[False] * c for _ in range(r)] for _ in range(l)]
    # print(visited)

    time = bfs(start)
    if time == -1:
        print("Trapped!")
    else:
        print(f"Escaped in {time} minute(s).")