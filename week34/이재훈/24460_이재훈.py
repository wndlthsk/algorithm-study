import sys
input = sys.stdin.readline

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

def recursion(x, y, n):
  if n == 1:
    return board[x][y]
  
  h = n // 2
  a = recursion(x, y, h)  # 좌상
  b = recursion(x + h, y, h)  # 우상
  c = recursion(x, y + h, h)  # 좌하
  d = recursion(x + h, y + h, h)  # 우하
  return sorted((a, b, c, d))[1]      # 두 번째로 작은 값
print(recursion(0, 0, N))