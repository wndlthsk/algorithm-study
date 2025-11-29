import sys
input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(map(int, input().strip())) for _ in range(N)]

# Prefix Sum (2D)
psum = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(N):
  for j in range(M):
    psum[i + 1][j + 1] = (
      board[i][j]
      + psum[i][j + 1]
      + psum[i + 1][j]
      - psum[i][j]
    )

def rect_sum(r1, c1, r2, c2):
  return (
    psum[r2][c2]
    - psum[r1][c2]
    - psum[r2][c1]
    + psum[r1][c1]
  )

ans = 0

# 1) 세로로 3개 분할
for i in range(1, M - 1):
  for j in range(i + 1, M):
    r1 = rect_sum(0, 0, N, i)
    r2 = rect_sum(0, i, N, j)
    r3 = rect_sum(0, j, N, M)
    ans = max(ans, r1 * r2 * r3)

# 2) 가로로 3개 분할
for i in range(1, N - 1):
  for j in range(i + 1, N):
    r1 = rect_sum(0, 0, i, M)
    r2 = rect_sum(i, 0, j, M)
    r3 = rect_sum(j, 0, N, M)
    ans = max(ans, r1 * r2 * r3)

# 3) 세로 -> 오른쪽 가로 2등분
for i in range(1, M):
  for j in range(1, N):
    r1 = rect_sum(0, 0, N, i)
    r2 = rect_sum(0, i, j, M)
    r3 = rect_sum(j, i, N, M)
    ans = max(ans, r1 * r2 * r3)

# 4) 세로 -> 왼쪽 가로 2등분
for i in range(1, M):
  for j in range(1, N):
    r1 = rect_sum(0, 0, j, i)
    r2 = rect_sum(j, 0, N, i)
    r3 = rect_sum(0, i, N, M)
    ans = max(ans, r1 * r2 * r3)

# 5) 가로 -> 아래쪽 세로 2등분
for i in range(1, N):
  for j in range(1, M):
    r1 = rect_sum(0, 0, i, M)
    r2 = rect_sum(i, 0, N, j)
    r3 = rect_sum(i, j, N, M)
    ans = max(ans, r1 * r2 * r3)

# 6) 가로 -> 위쪽 세로 2등분
for i in range(1, N):
  for j in range(1, M):
    r1 = rect_sum(0, 0, i, j)
    r2 = rect_sum(0, j, i, M)
    r3 = rect_sum(i, 0, N, M)
    ans = max(ans, r1 * r2 * r3)

print(ans)