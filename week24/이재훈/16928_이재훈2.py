from collections import deque
N, M = map(int, input().split())

d = {}
for _ in range(N):
  x, y = map(int, input().split())
  d[x] = y

for _ in range(M):
  u, v = map(int, input().split())
  d[u] = v

def bfs(pos):
  visited = [False] * 101
  q = deque()
  visited[pos] = True
  q.append((pos, 0))
  
  while q:
    pos, cnt = q.popleft()
    
    if pos == 100:
      return cnt
    
    for dice in range(1, 7):
      next = pos + dice
      if next > 100:
        continue
      if next in d.keys():
        next = d[next]
      if not visited[next]:
        visited[next] = True
        q.append((next, cnt + 1))
  return -1

print(bfs(1))