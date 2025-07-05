import sys
N, K = map(int, sys.stdin.readline().split())
bags = []
for _ in range(N):
    bags.append(list(map(int, sys.stdin.readline().split())))

dp = [[0] * (K+1) for _ in range(N+1)]
for i in range(1, N+1):
    for j in range(1, K+1):
        if j >= bags[i-1][0]:
            dp[i][j] = max(bags[i-1][1] + dp[i-1][j-bags[i-1][0]], dp[i-1][j])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][K])