R, C, T = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(R)]

# 공기청정기 위치(위/아래 행)
top, bottom = -1, -1
for i in range(R):
  if board[i][0] == -1:
    top = i
    bottom = i + 1
    break

dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

"""미세먼지 동시 확산 (임시 보드 사용)"""
def spread(bd):
  tmp = [[0] * C for _ in range(R)]
  tmp[top][0] = tmp[bottom][0] = -1  # 청정기 유지

  for x in range(R):
    for y in range(C):
      if bd[x][y] > 0:
        amt = bd[x][y] // 5
        if amt == 0:
          tmp[x][y] += bd[x][y]
          continue
        cnt = 0
        for dx, dy in dirs:
          nx, ny = x + dx, y + dy
          if 0 <= nx < R and 0 <= ny < C and bd[nx][ny] != -1:
            tmp[nx][ny] += amt
            cnt += 1
        tmp[x][y] += bd[x][y] - amt * cnt
  return tmp

"""공기청정기 순환: 위(반시계), 아래(시계)"""
def purify(bd):
  # 위쪽(반시계)
  for r in range(top - 1, 0, -1):        # 좌측 세로: 아래→위
    bd[r][0] = bd[r - 1][0]
  for c in range(0, C - 1):              # 맨 윗줄: 좌→우
    bd[0][c] = bd[0][c + 1]
  for r in range(0, top):                # 우측 세로: 위→아래
    bd[r][C - 1] = bd[r + 1][C - 1]
  for c in range(C - 1, 1, -1):          # top행: 우→좌
    bd[top][c] = bd[top][c - 1]
  bd[top][1] = 0

  # 아래쪽(시계)
  for r in range(bottom + 1, R - 1):     # 좌측 세로: 위→아래
    bd[r][0] = bd[r + 1][0]
  for c in range(0, C - 1):              # 맨 아랫줄: 좌→우
    bd[R - 1][c] = bd[R - 1][c + 1]
  for r in range(R - 1, bottom, -1):     # 우측 세로: 아래→위
    bd[r][C - 1] = bd[r - 1][C - 1]
  for c in range(C - 1, 1, -1):          # bottom행: 우→좌
    bd[bottom][c] = bd[bottom][c - 1]
  bd[bottom][1] = 0

  bd[top][0] = bd[bottom][0] = -1  # 청정기 위치 복구

for _ in range(T):
  board = spread(board)
  purify(board)

# 결과 합산 (청정기 -1 제외)
res = 0
for i in range(R):
  for j in range(C):
    if board[i][j] > 0:
      res += board[i][j]
print(res)
