def solution(n):
    board = [[0] * n for _ in range(n)]
    total = n * (n + 1) // 2
    
    DIR = [[1, 0], [0, 1], [-1, -1]]
    
    num = 1
    direction = 0
    cur_x, cur_y = 0, 0
    while num <= total:
        board[cur_x][cur_y] = num
        num += 1
        dx, dy = DIR[direction]
        nx, ny = cur_x + dx, cur_y + dy
        
        if not (0 <= nx < n and 0 <= ny < n) or board[nx][ny] != 0:
            direction = (direction + 1) % 3
            dx, dy = DIR[direction]
            nx, ny = cur_x + dx, cur_y + dy
        
        cur_x, cur_y = nx, ny
    
    res = []
    for i in range(n):
        for j in range(n):
            target = board[i][j]
            if target != 0:
                res.append(target)
    
    return res