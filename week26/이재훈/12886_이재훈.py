from collections import deque
A, B, C = map(int, input().split())
S = A + B + C

if S % 3 != 0:
  print(0)
  exit()

visited = [[False] * (S + 1) for _ in range(S + 1)]
q = deque()

def add_state(x, y):
  if not visited[x][y]:
    visited[x][y] = True
    q.append((x, y))

add_state(A, B)

is_failed = True
while q:
  x, y = q.popleft()
  z = S - x - y
  if x == y == z:
    print(1)
    is_failed = False
    break
  for a, b in [(x, y), (x, z), (y, z)]:
    if a == b:
      continue
    small, big = min(a, b), max(a, b)
    new_small = small * 2
    new_big = big - small
    # new_third = S - new_small - new_big
    add_state(new_small, new_big)

if is_failed:
  print(0)
