def solution(keyinput, board):
    max_x, max_y = board[0], board[1]
    X_OFFSET = max_x // 2
    Y_OFFSET = max_y // 2
    
    DIR = {
        "left": [-1, 0], "right": [1, 0],
        "up": [0, 1], "down": [0, -1]
    }
    
    cur_x, cur_y = X_OFFSET, Y_OFFSET
    for cmd in keyinput:
        dx, dy = DIR[cmd]
        if 0 <= cur_x + dx < max_x:
            cur_x += dx
        if 0 <= cur_y + dy < max_y:
            cur_y += dy
    
    return [cur_x - X_OFFSET, cur_y - Y_OFFSET]