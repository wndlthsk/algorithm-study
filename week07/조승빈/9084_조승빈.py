n = int(input())
for _ in range(n):
    T = int(input())
    arr = list(map(int,input().split(" ")))
    M = int(input())
    dp = [0]*(M+1)
    dp[0] = 1
    for a  in arr:
        for i in range(a,M+1):
            dp[i] += dp[i-a]
    print(dp[M])