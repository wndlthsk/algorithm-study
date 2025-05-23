R, C, N = map(int, input().split())
grid = [list(input()) for _ in range(R)]

def explode(board):
    exploded = [['O'] * C for _ in range(R)]
    nx = [-1,1,0,0]
    ny = [0,0,-1,1]
    for i in range(R):
        for j in range(C):
            if board[i][j] == 'O':
                exploded[i][j] = '.'
                for idx in range(4):
                    ni, nj = i + nx[idx], j + ny[idx]
                    if 0 <= ni < R and 0 <= nj < C:
                        exploded[ni][nj] = '.'
    return exploded

if N == 1:
    result = grid
elif N % 2 == 0:
    result = [['O'] * C for _ in range(R)]
else:
    first = explode(grid)
    result = explode(first)
    if N % 4 == 3 :
        result = first 

for row in result:
    print(''.join(row))
