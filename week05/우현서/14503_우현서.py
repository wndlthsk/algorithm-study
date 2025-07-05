import sys

n, m = map(int, sys.stdin.readline().split())
r, c, d = map(int, sys.stdin.readline().split())
board = []
for i in range(n):
    board.append(list(map(int, sys.stdin.readline().split())))

# print(board)

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]

count = 0
while True:
    if board[r][c] == 0:
        count += 1
        board[r][c] = -1 # 청소 완료

    count_4 = 0
    for i in range(4):
        d = (d-1) % 4
        nr = r + dy[d]
        nc = c + dx[d]
        if 0 <= nr < n and 0 <= nc < m and board[nr][nc] == 0:
            r = nr
            c = nc
            count_4 += 1
            break

    if count_4 == 0:
        nr = r - dy[d]
        nc = c - dx[d]
        if 0 <= nr < n and 0 <= nc < m and board[nr][nc] != 1:
            r = nr
            c = nc
            continue
        else:
            break

print(count)