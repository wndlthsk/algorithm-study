import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[-float('inf')] * m for _ in range(n)]  
dp[0][0] = arr[0][0]  
for i in range(1, m): 
    dp[0][i] = dp[0][i-1] + arr[0][i]
for i in range(1, n):
    left = [-float('inf')] * m
    right = [-float('inf')] * m

    left[0] = dp[i-1][0] + arr[i][0]
    for j in range(1, m):
        left[j] = max(left[j-1], dp[i-1][j]) + arr[i][j]
    right[m-1] = dp[i-1][m-1] + arr[i][m-1]
    for j in range(m-2, -1, -1):
        right[j] = max(right[j+1], dp[i-1][j]) + arr[i][j]  
    for j in range(m):
        dp[i][j] = max(left[j], right[j])
print(dp[n-1][m-1])  
