T = int(input())
arr = []
for _ in range(T):
    arr.append(int(input()))

dp = [(1, 0), (0, 1)]
for i in range(2, 41):
    a, b = dp[i - 1]
    c, d = dp[i - 2]
    dp.append((a + c, b + d))
for n in arr:
    print(dp[n][0], dp[n][1])
