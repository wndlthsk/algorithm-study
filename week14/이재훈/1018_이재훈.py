N, M = map(int, input().split())

board = [list(input()) for _ in range(N)]

def count_repaint(x, y):
  repaint_w = 0  # (x,y)를 W로 시작
  repaint_b = 0  # (x,y)를 B로 시작
  for i in range(8):
    for j in range(8):
      expected_color = 'W' if (i + j) % 2 == 0 else 'B'
      if board[x + i][y + j] != expected_color:
        repaint_w += 1
      # 반대 색 시작
      expected_color = 'B' if (i + j) % 2 == 0 else 'W'
      if board[x + i][y + j] != expected_color:
        repaint_b += 1
  return min(repaint_w, repaint_b)

min_repaint = float('inf')
for i in range(N - 7):
  for j in range(M - 7):
    min_repaint = min(min_repaint, count_repaint(i, j))

print(min_repaint)