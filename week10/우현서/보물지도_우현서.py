# m x n 지도, 맨 오른쪽 위 칸 (n, m)에 보물
# 함정있는 칸은 못 지나감
# 맨 왼쪽 아레(1,1)에서 출발, 4방향 이동 가능, 한칸 이동시 시간 1
# 신발 -> 한번에 두칸 or 함정 뛰어넘기 가능, 신발은 한번만 사용 가능, 두칸 이동시 시간 1
# 출발점에서 보물 칸으로 이동하는 최소 시간

from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(i, j, visited, n, m, hole):
    visited[i][j][0] = True
    queue = deque([(i, j, 0, 0)])  # i, j, time, used

    while queue:
        x, y, time, used = queue.popleft()

        if x == 0 and y == n - 1:  # 보물 칸 도착
            return time

        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < m and 0 <= ny < n:
                if not visited[nx][ny][used] and (nx, ny) not in hole:
                    queue.append((nx, ny, time + 1, used))
                    visited[nx][ny][used] = True

            if used == 0:  # 신발 안쓴 상태일때, 쓴 경우 고려하기
                nx2, ny2 = x + dx[d] * 2, y + dy[d] * 2
                if 0 <= nx2 < m and 0 <= ny2 < n:
                    if not visited[nx2][ny2][1] and (nx2, ny2) not in hole:
                        queue.append((nx2, ny2, time + 1, 1))
                        visited[nx2][ny2][1] = True
    return -1


def solution(n, m, hole):
    answer = 0
    new_hole = set()  # 함정 좌표 변환, list쓰면 not in 할때 시간초과->set으로 변경
    for x, y in hole:
        new_hole.add((m - y, x - 1))

    visited = [[[False] * 2 for _ in range(n)] for _ in range(m)]  # visited[x][y][used] 배열
    answer = bfs(m - 1, 0, visited, n, m, new_hole)

    return answer