import sys
input = sys.stdin.read
sys.setrecursionlimit(10000)


n = input().split()
idx = 0
N = int(n[idx]); idx += 1
arr = [0] + list(map(int, n[idx:idx+N]))  
idx += N
M = int(n[idx]); idx += 1
queries = []
for _ in range(M):
    S = int(n[idx])
    E = int(n[idx+1])
    queries.append((S, E))
    idx += 2
dp = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(1, N+1):
    dp[i][i] = 1
for i in range(1, N):
    if arr[i] == arr[i+1]:
        dp[i][i+1] = 1
for length in range(3, N+1):
    for s in range(1, N - length + 2):
        e = s + length - 1
        if arr[s] == arr[e] and dp[s+1][e-1] == 1:
            dp[s][e] = 1
ans = []
for s, e in queries:
    ans.append(str(dp[s][e]))
print('\n'.join(ans))
