def solution(board):
    DIR = [
        [0, 1], [0, -1], [1, 0], [-1, 0],
        [-1, -1], [-1, 1], [1, -1], [1, 1]
    ]
    
    n = len(board)
    danger = [[0] * n for _ in range(n)]
    for r in range(n):
        for c in range(n):
            if board[r][c] == 1:
                danger[r][c] = 1
                for dr, dc in DIR:
                    nr, nc = r + dr, c + dc
                    if 0 <= nr < n and 0 <= nc < n:
                        danger[nr][nc] = 1
    
    cnt = 0
    for i in range(n):
        for j in range(n):
            if danger[i][j] == 0:
                cnt += 1
    
    return cnt