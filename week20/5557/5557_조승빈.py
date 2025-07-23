n = int(input())
arr = list(map(int, input().split()))
dp = [0] * 21
dp[arr[0]] = 1
for i in range(1, n - 1):
    next = [0] * 21
    for j in range(21):
        if dp[j]:
            plus = j + arr[i]
            minus = j - arr[i]
            if 0 <= plus <= 20:
                next[plus] += dp[j]
            if 0 <= minus <= 20:
                next[minus] += dp[j]
    dp = next
print(dp[arr[-1]])
