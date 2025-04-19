import sys
from collections import deque

n, l, r = map(int, sys.stdin.readline().split())
country = []
for _ in range(n):
    country.append(list(map(int, sys.stdin.readline().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, visited):
    q = deque()
    q.append((x, y))
    union = [(x, y)]
    visited[x][y] = 1
    total = country[x][y]

    while q:
        i, j = q.popleft()
        for k in range(4):
            ni, nj = i + dx[k], j + dy[k]
            if 0 <= ni < n and 0 <= nj < n and visited[ni][nj] == 0:
                if l <= abs(country[i][j] - country[ni][nj]) <= r:
                    visited[ni][nj] = 1
                    q.append((ni, nj))
                    union.append((ni, nj))
                    total += country[ni][nj]

    return union, total


count = 0
while True:
    check = 0 # 움직였으면 1
    visited = [[0] * n for _ in range(n)] # (i, j)가 이미 어느 연합에 속했는지 체크
    for i in range(n):
        for j in range(n):
            # print(i, j)
            if visited[i][j] == 0: # 연합 찾은 건 다시 안보게 하기 위해서 넣어야 함
                union, total = bfs(i, j, visited) # 연합구하기, (i,j)를 기준으로 하나의 연합을 찾음
                # for c in country:
                #     print(*c)
                # print("union:", union)
                if len(union) >= 2: # 연합 발생 -> 인구 이동
                    new_value = total // len(union)
                    for x, y in union:
                        country[x][y] = new_value
                    check = 1 # 이동이 있었는지 여부, 없었으면 while 종료

            # for c in country:
            #     print(*c)

    if check == 0:
        break
    count += 1

print(count)