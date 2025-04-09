import sys

n = int(sys.stdin.readline())
t = [0]
p = [0]
for _ in range(n):
    a, b = map(int, sys.stdin.readline().split())
    t.append(a)
    p.append(b)


# dp[i]: i일부터 퇴사 날까지 받을 수 있는 최대 이익
# i일에 일 안하면, 이전까지 일한 값넣기
# i일에 일하면, 그날 이익+ 걸린 시간 넘어간 후 가질 수 있는 최대 이익

dp = [0] * (n+2)

for i in range(n, 0, -1):
    # print("i", i)
    if i+t[i] > n+1:
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], p[i] + dp[i+t[i]])

print(dp[1])