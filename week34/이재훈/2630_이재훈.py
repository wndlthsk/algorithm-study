N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

def recursion(x, y, n):
  color = board[x][y]

  # 현재 구역이 모두 같은 색인지 확인
  for i in range(x, x + n):
    for j in range(y, y + n):
      if board[i][j] != color:
        # 색이 섞여 있으면 4등분하여 재귀 호출
        w1, b1 = recursion(x, y, n // 2)
        w2, b2 = recursion(x, y + n // 2, n // 2)
        w3, b3 = recursion(x + n // 2, y, n // 2)
        w4, b4 = recursion(x + n // 2, y + n // 2, n // 2)
        return (w1 + w2 + w3 + w4, b1 + b2 + b3 + b4)
  
  # 모두 같은 색이면 해당 색종이만 카운트
  if color == 1:
    return (0, 1)
  else:
    return (1, 0)

white, blue = recursion(0, 0, N)
print(white)
print(blue)