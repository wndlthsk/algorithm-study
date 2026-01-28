import sys
input = sys.stdin.readline

N = int(input())
numbers = list(map(int, input().split()))
M = int(input())
se = [list(map(int, input().split())) for _ in range(M)]

dp = [[0] * N for _ in range(N)]

for i in range(N):
  dp[i][i] = 1

for i in range(N - 1):
  if numbers[i] == numbers[i + 1]:
    dp[i][i + 1] = 1

for length in range(3, N + 1):
  for start in range(N - length + 1):
    end = start + length - 1
    if numbers[start] == numbers[end] and dp[start + 1][end - 1]:
      dp[start][end] = 1

res = []
for s, e in se:
  res.append(dp[s - 1][e - 1])
print('\n'.join(map(str, res)))