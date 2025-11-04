N = int(input())
board = [list(map(int, input())) for _ in range(N)]

def recursion(x, y, n):
  # 현재 영역이 모두 같은 숫자인지 확인
  first = board[x][y]
  for i in range(x, x + n):
    for j in range(y, y + n):
      if board[i][j] != first:
        half = n // 2
        # 4분할 + 괄호로 묶기
        return (
            "("
            + recursion(x, y, half)
            + recursion(x, y + half, half)
            + recursion(x + half, y, half)
            + recursion(x + half, y + half, half)
            + ")"
        )
  # 모두 같다면 해당 숫자 리턴
  return str(first)

print(recursion(0, 0, N))