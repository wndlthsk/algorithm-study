import sys
sys.setrecursionlimit(10000)

N = int(input())
house = [list(map(int, input().split())) for _ in range(N)]


dp = [[[-1]*3 for _ in range(N)] for _ in range(N)]

def dfs(r, c, direction):
    if r == N-1 and c == N-1:
        return 1

    if dp[r][c][direction] != -1:
        return dp[r][c][direction]
    ways = 0
    if direction == 0 or direction == 2:
        if c + 1 < N and house[r][c+1] == 0:
            ways += dfs(r, c+1, 0)
    if direction == 1 or direction == 2:
        if r + 1 < N and house[r+1][c] == 0:
            ways += dfs(r+1, c, 1)
    if r + 1 < N and c + 1 < N:
        if house[r][c+1] == 0 and house[r+1][c] == 0 and house[r+1][c+1] == 0:
            ways += dfs(r+1, c+1, 2)
    dp[r][c][direction] = ways
    return ways


print(dfs(0, 1, 0))
