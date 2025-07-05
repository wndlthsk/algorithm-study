import sys
n = int(sys.stdin.readline())

house = []
for i in range(n):
    house.append(list(map(int, sys.stdin.readline().split())))

dp = [[[0]*3 for _ in range(n)] for _ in range(n)]
dp[0][1][0] = 1 # 초기 파이프 위치

for j in range(2, n): # 0행은 가로로 오는 경우 1가지
    if house[0][j] == 0:
        dp[0][j][0] = 1
    else:
        break

for i in range(1, n):
    for j in range(2, n):
        if house[i][j] == 0: # 벽 처리
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
        if house[i][j] == 0: # 벽 처리
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]
        if house[i][j] == 0 and house[i-1][j] == 0 and house[i][j-1] == 0: # 벽 처리(색깔 참고함)
            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]

# for d in dp:
#     print(d)

print(sum(dp[n-1][n-1]))

