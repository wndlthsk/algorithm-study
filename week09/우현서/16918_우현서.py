import sys

# r x c 격자판, 비어있거나 폭탄
# 폭탄 이씅면 3초 후 폭발, 폭탄 칸 + 인접 4칸 파괴, 연쇄 반응 x
# 봄버맨의 격자판 이동
# 1. 일부 칸에 폭탄 설치
# 2. 다음 1초간 가만히
# 3. 다음 1초간 폭탄이 설치 안된 모든 칸에 폭탄 설치 -> 모든 칸은 폭탄 가짐
# 4. 1초 후 3초 전에 설치된 폭탄 모두 폭발
# 5. 3,4 반복

r, c, n = map(int, sys.stdin.readline().split())
board = []
for _ in range(r):
    board.append(list(sys.stdin.readline().rstrip()))

# 1
time = 0
time_board = [[-1] * c for _ in range(r)]
for i in range(r):
    for j in range(c):
        if board[i][j] == 'O':
            time_board[i][j] = time
# 2
time += 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while time <= n:
    if time % 2 == 0: # 3
        for i in range(r):
            for j in range(c):
                if time_board[i][j] == -1:
                    time_board[i][j] = time
    else: # 4
        bomb = []
        for i in range(r):
            for j in range(c):
                if time_board[i][j] == time - 3:
                    bomb.append((i, j))

        for i, j in bomb:
            time_board[i][j] = -1
            for d in range(4):
                ni, nj = i + dx[d], j + dy[d]
                if 0 <= ni < r and 0 <= nj < c and time_board[ni][nj] != time - 3:
                    time_board[ni][nj] = -1
    time += 1

for i in range(r):
    for j in range(c):
        if time_board[i][j] == -1:
            print('.', end='')
        else:
            print('O', end='')
    print()