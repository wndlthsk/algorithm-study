def solution(n):
    DIR = [[0, 1], [1, 0], [0, -1], [-1, 0]]

    board = [[0] * n for _ in range(n)]
    d_idx = 0
    r, c = 0, 0
    number = 0
    while number < n * n:
        number += 1
        board[r][c] = number
        
        nr, nc = r + DIR[d_idx][0], c + DIR[d_idx][1]
        if not (0 <= nr < n and 0 <= nc < n) or board[nr][nc] != 0:
            d_idx = (d_idx + 1) % 4
            nr, nc = r + DIR[d_idx][0], c + DIR[d_idx][1]
        
        r, c = nr, nc
    
    return board