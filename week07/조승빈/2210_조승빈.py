board = [list(input().split()) for _ in range(5)]

dx = [-1, 1, 0, 0]  
dy = [0, 0, -1, 1]

result = set()

def dfs(x, y, path):
    if len(path) == 6:
        result.add(path)
        return
    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0 <= nx < 5 and 0 <= ny < 5:
            dfs(nx, ny, path + board[nx][ny])

for i in range(5):
    for j in range(5):
        dfs(i, j, board[i][j])

print(len(result))
