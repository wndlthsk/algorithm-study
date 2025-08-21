N = int(input())
board = list(map(int, input().split()))
M = int(input())
SE = [list(map(int, input().split())) for _ in range(M)]

# dp[i][j] = board[i..j]가 팰린드롬이면 True
dp = [[False] * N for _ in range(N)]

# 길이 1: 항상 팰린드롬
for i in range(N):
  dp[i][i] = True

# 길이 2: 양쪽 숫자가 같으면 팰린드롬
for i in range(N-1):
  if board[i] == board[i+1]:
    dp[i][i+1] = True

# 길이 3 이상
for length in range(3, N+1):
  for i in range(N-length+1):
    j = i + length - 1
    if board[i] == board[j] and dp[i+1][j-1]:
      dp[i][j] = True

# 쿼리 답 출력
for s, e in SE:
  # 입력은 1-based라서 -1
  print(1 if dp[s-1][e-1] else 0)
