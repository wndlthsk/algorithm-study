N, M = map(int, input().split())
grid = [input().strip() for _ in range(N)]
max_size = 1

for i in range(N):
    for j in range(M):
        for d in range(1, min(N - i, M - j)):
            if grid[i][j] == grid[i + d][j] == grid[i][j + d] == grid[i + d][j + d]:
                max_size = max(max_size, (d + 1) ** 2)

print(max_size)
