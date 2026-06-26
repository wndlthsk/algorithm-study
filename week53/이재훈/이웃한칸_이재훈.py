def solution(board, h, w):
    n = len(board)
    color = board[h][w]
    count = 0

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    for i in range(4):
        nr = h + dr[i]
        nc = w + dc[i]

        if 0 <= nr < n and 0 <= nc < n:
            if board[nr][nc] == color:
                count += 1

    return count