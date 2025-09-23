N, M, x, y, K = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
control = list(map(int, input().split()))

# 동, 서, 북, 남
direction = {
  1: (0, 1),
  2: (0, -1),
  3: (-1, 0),
  4: (1, 0)
}

# dice[0]=윗, dice[5]=아랫
dice = [0] * 6

def roll(d):
  top, back, right, left, front, bottom = dice
  if d == 1:  # 동
    dice[0], dice[2], dice[5], dice[3] = left, top, right, bottom
  elif d == 2:  # 서
    dice[0], dice[2], dice[5], dice[3] = right, bottom, left, top
  elif d == 3:  # 북
    dice[0], dice[1], dice[5], dice[4] = front, top, back, bottom
  elif d == 4:  # 남
    dice[0], dice[1], dice[5], dice[4] = back, bottom, front, top

r, c = x, y
for d in control:
  dr, dc = direction[d]
  nr, nc = r + dr, c + dc
  if not (0 <= nr < N and 0 <= nc < M):
    continue
  r, c = nr, nc
  roll(d)
  
  if board[r][c] == 0:
    board[r][c] = dice[5]  # 아랫면 복사
  else:
    dice[5] = board[r][c]  # 주사위 아랫면에 복사
    board[r][c] = 0
  print(dice[0])  # 윗면 출력
