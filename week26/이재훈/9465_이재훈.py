T = int(input())
for _ in range(T):
  n = int(input())
  board = [list(map(int, input().split())) for _ in range(2)]
  
  dp = [[0] * 3 for _ in range(n)]
  # dp[i][j]: i번째 열에 j행을 선택한 최댓값
  
  dp[0][0] = board[0][0]
  dp[0][1] = board[1][0]
  dp[0][2] = 0
  for i in range(1, n):
    dp[i][0] = max(dp[i - 1][1], dp[i - 1][2]) + board[0][i]
    dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + board[1][i]
    dp[i][2] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
  print(max(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]))