from collections import deque
n = int(input())
start, end = map(int, input().split())
m = int(input())
relations = [list(map(int, input().split())) for _ in range(m)]
linked_list = {}
for x, y in relations:
  if x not in linked_list:
    linked_list[x] = [y]
  else:
    linked_list[x].append(y)
  if y not in linked_list:
    linked_list[y] = [x]
  else:
    linked_list[y].append(x)

visited = [False] * (n + 1)
def bfs(start):
  q = deque()
  visited[start] = True
  q.append((start, 0))
  
  while q:
    next, cnt = q.popleft()
    if next == end:
      return cnt
    
    for man in linked_list[next]:
      if not visited[man]:
        visited[man] = True
        q.append((man, cnt + 1))
  return -1
print(bfs(start))
