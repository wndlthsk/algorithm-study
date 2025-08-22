from collections import deque

N, M = map(int, input().split())

jump = {}
for _ in range(N):
  x, y = map(int, input().split())
  jump[x] = y
for _ in range(M):
  u, v = map(int, input().split())
  jump[u] = v

def bfs(start):
  visited = [False] * 101
  q = deque([(start, 0)])  # (현재 위치, 주사위 횟수)
  visited[start] = True
  
  while q:
    pos, cnt = q.popleft()
    
    if pos == 100:
      return cnt
    
    for dice in range(1, 7):
      nxt = pos + dice
      if nxt > 100:
        continue
      if nxt in jump:  # 사다리나 뱀 있으면 점프
        nxt = jump[nxt]
      if not visited[nxt]:
        visited[nxt] = True
        q.append((nxt, cnt+1))
  return -1  # 도달 못하는 경우 (문제 조건상 없음)
print(bfs(1))