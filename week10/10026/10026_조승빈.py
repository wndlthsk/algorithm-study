from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, vis, arr, color_mode):
    queue = deque()
    queue.append((x, y))
    vis[x][y] = True
    start_color = arr[x][y]

    while queue:
        cx, cy = queue.popleft()
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not vis[nx][ny]:
                target_color = arr[nx][ny]
                if color_mode == 'normal':
                    if target_color == start_color:
                        vis[nx][ny] = True
                        queue.append((nx, ny))
                elif color_mode == 'colorblind':
                    if start_color == 'B':
                        if target_color == 'B':
                            vis[nx][ny] = True
                            queue.append((nx, ny))
                    else:
                        if target_color in ('R', 'G'):
                            vis[nx][ny] = True
                            queue.append((nx, ny))

def count_areas(arr, color_mode):
    vis = [[False] * n for _ in range(n)]
    count = 0
    for x in range(n):
        for y in range(n):
            if not vis[x][y]:
                bfs(x, y, vis, arr, color_mode)
                count += 1
    return count


n = int(input())
arr = [list(input().strip()) for _ in range(n)]

print(count_areas(arr, 'normal'), count_areas(arr, 'colorblind'))
