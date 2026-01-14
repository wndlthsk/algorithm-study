board = [list(map(int, input().split())) for _ in range(9)]

max_value = float('-inf')
r = 0
for idx, row in enumerate(board):
  m = max(row)
  if max_value < m:
    max_value = m
    r = idx

c = board[r].index(max_value)

print(max_value)
print(r + 1, c + 1)