from collections import deque
A, B, C = map(int, input().split())
S = A + B + C

# 합이 3으로 나누어떨어지지 않으면 불가능
if S % 3 != 0:
  print(0)
  exit(0)

def move(x, y):
  """x != y 일 때, (x<y) 가정하에 (2x, y-x) 반환"""
  if x < y:
    return x + x, y - x
  else:
    return x - y, y + y  # x>y인 경우 대칭 처리


# visited[a][b]만 관리(세 번째는 S-a-b로 결정)
MAX = 1500  # A,B,C ≤ 500 → S ≤ 1500
visited = [[False] * (MAX + 1) for _ in range(MAX + 1)]

# 상태 정규화: 오름차순
a, b, c = sorted([A, B, C])

q = deque()
visited[a][b] = True
q.append((a, b))

res = 0
while q:
  a, b = q.popleft()
  c = S - a - b
  if a == b == c:
    res = 1
    break

  for x, y in ((a, b), (a, c), (b, c)):
    if x == y:
      continue
    nx, ny = move(x, y)
    nz = S - nx - ny
    na, nb, nc = sorted((nx, ny, nz))
    if not visited[na][nb]:
      visited[na][nb] = True
      q.append((na, nb))
print(res)