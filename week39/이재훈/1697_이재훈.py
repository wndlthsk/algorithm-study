from collections import deque
N, K = map(int, input().split())

visited = [False] * 100001
q = deque()

q.append((N, 0))
visited[N] = True

while q:
  x, time = q.popleft()

  if x == K:
    print(time)
    break

  for nx in (x - 1, x + 1, x * 2):
    if 0 <= nx <= 100000 and not visited[nx]:
      visited[nx] = True
      q.append((nx, time + 1))