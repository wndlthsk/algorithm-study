n,m = map(int,input().split(" "))
arr =[]
for _ in range(n):
    arr.append(list(map(int,input().split(" "))))
dp = [[0 for _ in range(m)]for _ in range(n)]
ans = 0
for x in range(n):
    for y in range(m):
        left = 0
        up = 0
        diagonal = 0
        if  y-1 >=0:
            left = dp[x][y-1]
        if x-1>= 0:
            up = dp[x-1][y]
        if x-1>=0 and y-1>=0:
            diagonal = dp[x-1][y-1]
        dp[x][y]+=(arr[x][y]+ max(left,up,diagonal))
print(dp[-1][-1])
