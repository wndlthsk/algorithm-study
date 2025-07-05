import sys

n, m = map(int, sys.stdin.readline().split())
mars = []
for _ in range(n):
    mars.append(list(map(int, sys.stdin.readline().split())))

dp = [[0 for _ in range(m)] for _ in range(n)]
dp[0][0] = mars[0][0]
for j in range(1, m):
    dp[0][j] = dp[0][j-1] + mars[0][j]

for i in range(1, n):
    left_dp = [0 for _ in range(m)]
    left_dp[0] = dp[i - 1][0] + mars[i][0]
    for j in range(1, m):
        left_dp[j] = mars[i][j] + max(left_dp[j-1], dp[i-1][j])

    right_dp = [0 for _ in range(m)]
    right_dp[m-1] = dp[i-1][m-1] + mars[i][m-1]
    for j in range(m-2, -1, -1):
        right_dp[j] = mars[i][j] + max(right_dp[j+1], dp[i-1][j])

    # print("left dp: ", left_dp)
    # print("right dp: ", right_dp)
    for j in range(m):
        dp[i][j] = max(left_dp[j], right_dp[j])

print(dp[n-1][m-1])