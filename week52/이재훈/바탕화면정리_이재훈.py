def solution(wallpaper):
    board = list(map(list, wallpaper))
    
    len_r = len(board)
    len_c = len(board[0])
    
    min_r, max_r = float('inf'), float('-inf')
    min_c, max_c = float('inf'), float('-inf')
    for r in range(len_r):
        for c in range(len_c):
            if board[r][c] == '#':
                min_c = min(min_c, c)
                max_c = max(max_c, c)
                min_r = min(min_r, r)
                max_r = max(max_r, r)
    
    return [min_r, min_c, max_r + 1, max_c + 1]