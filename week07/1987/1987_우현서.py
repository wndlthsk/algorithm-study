import sys
sys.setrecursionlimit(10000)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def dfs(x, y, count): # count == len(visited_alpha)
    global max_len
    max_len = max(max_len, count)

    for d in range(4):
        nx, ny = x + dx[d], y + dy[d]
        if 0<=nx<r and 0<=ny<c and board[nx][ny] not in visited_alpha:
            visited_alpha.add(board[nx][ny])
            dfs(nx, ny, count + 1)
            visited_alpha.remove(board[nx][ny])


r, c = map(int, sys.stdin.readline().split())
board = []
for _ in range(r):
    board.append(list(sys.stdin.readline().rstrip()))

max_len = 0
visited_alpha = set()
visited_alpha.add(board[0][0])
dfs(0, 0, 1)
print(max_len)