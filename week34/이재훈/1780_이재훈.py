N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

def recursion(x, y, n):
  num = board[x][y]
  for i in range(x, x + n):
    for j in range(y, y + n):
      if num != board[i][j]:
        div = n // 3
        a1, b1, c1 = recursion(x, y, div)
        a2, b2, c2 = recursion(x + div, y, div)
        a3, b3, c3 = recursion(x + 2 * div, y, div)
        a4, b4, c4 = recursion(x, y + div, div)
        a5, b5, c5 = recursion(x + div, y + div, div)
        a6, b6, c6 = recursion(x + 2 * div, y + div, div)
        a7, b7, c7 = recursion(x, y + 2 * div, div)
        a8, b8, c8 = recursion(x + div, y + 2 * div, div)
        a9, b9, c9 = recursion(x + 2 * div, y + 2 * div, div)
        return a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9, b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9, c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8 + c9, 
  
  if num == -1:
    return 1, 0, 0
  elif num == 0:
    return 0, 1, 0
  elif num == 1:
    return 0, 0, 1

cnt_num_minus, cnt_num_zero, cnt_num_plus = recursion(0, 0, N)
print(cnt_num_minus)
print(cnt_num_zero)
print(cnt_num_plus)