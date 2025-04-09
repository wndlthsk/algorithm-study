import sys
from collections import deque


def bfs(start_row, start_col, island_num):
    queue = deque([(start_row, start_col)])
    visited[start_row][start_col] = 1
    map_list[start_row][start_col] = island_num
    # print(queue)

    while queue:
        x, y = queue.popleft()
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if 0 <= nx < n and 0 <= ny <n and visited[nx][ny] == 0:
                if map_list[nx][ny] == 1:
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
                    map_list[nx][ny] = island_num


n = int(sys.stdin.readline())
map_list = []
for _ in range(n):
    map_list.append(list(map(int, sys.stdin.readline().rstrip().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[0] * n for _ in range(n)]
island = 2

# 섬 구분 bfs
for i in range(n):
    for j in range(n):
        if map_list[i][j] == 1 and visited[i][j] == 0:
            # print("i:", i, "j:", j, "island:", island)
            bfs(i, j, island)
            island += 1

# for m in map_list:
#     print(*m)

# 각 섬에서 다른 섬까지 bfs
minimum = float('inf')
# from_i, to_i = 0, 0
for i in range(2, island): # i == 섬 번호
    # print("i:", i)
    queue = deque()
    visited = [[-1] * n for _ in range(n)]

    for a in range(n):
        for b in range(n):
            if map_list[a][b] == i:
                queue.append((a, b))
                visited[a][b] = 0

    while queue:
        a, b = queue.popleft()
        for d in range(4):
            nx = a + dx[d]
            ny = b + dy[d]
            if 0 <= nx < n and 0 <= ny < n:
                # 같은 섬인 경우
                if map_list[nx][ny] == i:
                    continue
                # 바다인 경우
                if map_list[nx][ny] == 0 and visited[nx][ny] == -1:
                    queue.append((nx, ny))
                    visited[nx][ny] = visited[a][b] + 1
                # 다른 섬인 경우
                elif map_list[nx][ny] != i and map_list[nx][ny] != 0:
                    # if visited[a][b] < minimum:
                    #     from_i = i
                    #     to_i = map_list[nx][ny]
                    minimum = min(minimum, visited[a][b])
                    break  # 현재 위치에서 4방향 중단
    # print("from island:", i)
    # for k in visited:
    #     print(*k)
    # print("!", from_i, to_i)

print(minimum)
