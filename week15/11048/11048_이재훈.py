N, M = map(int, input().split())

board = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * M for _ in range(N)]

for i in range(N):
  for j in range(M):
    candy = board[i][j]
    
    can_go_1 = dp[i - 1][j] if i > 0 else 0
    can_go_2 = dp[i][j - 1] if j > 0 else 0
    can_go_3 = dp[i - 1][j - 1] if i > 0 and j > 0 else 0
    
    dp[i][j] = max(can_go_1, can_go_2, can_go_3) + candy
print(dp[N - 1][M - 1])