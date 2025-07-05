N = int(input())

board = [list(input()) for _ in range(N)]

max_cnt = 0
for i in range(N):
  friends = set()
  for j in range(N):
    if i == j:
      continue
    if board[i][j] == 'Y':
      friends.add(j)
    else:
      for k in range(N):
        if board[i][k] == 'Y' and board[k][j] == 'Y':
          friends.add(j)
          break
  max_cnt = max(max_cnt, len(friends))
print(max_cnt)
