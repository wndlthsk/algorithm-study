n = int(input())
arr= list(map(int,input().split(" ")))

dp = [0]*(n+1)
dp[0] = 0
dp[1] = arr[0]
for x in range(2,n+1):
    dp[x] = arr[x-1]
    for y in range(x+1):
        dp[x] = max(dp[x],dp[y]+dp[x-y])
print(dp[n])