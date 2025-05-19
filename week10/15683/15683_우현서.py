# n x m 사무실, k개 cctv
# cctv 종류 5개, 감시할 수 있는 방향에 있는 칸 전체를 감시함.
# 1: 한쪽, 2: 반대 양쪽, 3: 직각 양쪽, 4: 세방향, 5: 4방향
# 벽은 통과 못함 : 사각지대
# cctv 회전 90도, 감시 방향 가로 or 세로
# 0: 빈칸 / 1~5: cctv / 6: 벽

import sys, copy
from itertools import product

n, m = map(int, sys.stdin.readline().split())
office = []
cctvs = [] # cctv 위치, 종류
for i in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if 1<=temp[j]<=5:
            cctvs.append((i, j, temp[j]))
    office.append(temp)
# print("cctvs", cctvs)

# 0123: 위오아왼
directions = {
    1: [[0], [1], [2], [3]],
    2: [[1, 3], [0, 2]],
    3: [[0, 1], [1, 2], [2, 3], [3, 0]],
    4: [[0, 1, 3], [0, 1, 2], [1, 2, 3], [0, 2, 3]],
    5: [[0, 1, 2, 3]]
}

cctv_dirs = [] # 사무실에 있는 ccty 종류에 따라 갈 수 있는 방향 경우
for x, y, num in cctvs:
    if num == 1:
        cctv_dirs.append(directions[1])
    elif num == 2:
        cctv_dirs.append(directions[2])
    elif num == 3:
        cctv_dirs.append(directions[3])
    elif num == 4:
        cctv_dirs.append(directions[4])
    elif num == 5:
        cctv_dirs.append(directions[5])
# print("cctv_dirs", cctv_dirs)

cases = list(product(*cctv_dirs)) # 모든 방향 조합
# print("cases", cases)

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
result = n*m
for case in cases:
    temp_office = copy.deepcopy(office)
    for i in range(len(case)):
        x, y, temp_cctv = cctvs[i]
        temp_dir = case[i]
        for d in temp_dir:
            nx, ny = x, y
            while True:
                nx += dx[d]
                ny += dy[d]
                if 0<=nx<n and 0<=ny<m:
                    if temp_office[nx][ny] == 0:
                        temp_office[nx][ny] = -1 # 감시 가능 표시
                    elif temp_office[nx][ny] == 6:
                        break
                else:
                    break
    cannot = sum(row.count(0) for row in temp_office)
    result = min(result, cannot)

print(result)