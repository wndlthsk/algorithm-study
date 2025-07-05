import sys
input = sys.stdin.readline

N, M = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]

INF = float('inf')
dp = [[[INF]*3 for _ in range(M)] for _ in range(N)]

for j in range(M):
    for d in range(3):
        dp[0][j][d] = grid[0][j]

for i in range(1, N):
    for j in range(M):
        for d in range(3):
            for prev_d in range(3):
                if d == prev_d:
                    continue
                nj = j + (d - 1)
                if 0 <= nj < M:
                    dp[i][j][d] = min(dp[i][j][d], dp[i-1][nj][prev_d] + grid[i][j])

result = min(dp[N-1][j][d] for j in range(M) for d in range(3))
print(result)
