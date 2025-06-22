board = [list(input()) for _ in range(5)]

res = ''
row_len_lst = [len(row) for row in board]
max_len = max(row_len_lst)  # 가장 긴 줄 기준 반복

for col in range(max_len):  # 왼쪽부터 오른쪽으로
  for row in range(5):      # 위에서 아래로
    if col < row_len_lst[row]:  # 글자가 있을 때만
      res += board[row][col]
print(res)
