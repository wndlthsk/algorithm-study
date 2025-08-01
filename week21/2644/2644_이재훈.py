from collections import deque

n = int(input())
start, end = map(int, input().split())
m = int(input())

# 데이터 입력 구조를 인접 리스트로 변환. 데이터를 그대로 저장하지 않음.(BFS/DFS 활용). 탐색 시 효율 문제.
graph = [[] for _ in range(n + 1)]
for _ in range(m):
  x, y = map(int, input().split())
  graph[x].append(y)
  graph[y].append(x)

visited = [False] * (n + 1)

def bfs(start, target):
  q = deque()
  q.append((start, 0))
  visited[start] = True

  while q:
    pos, step = q.popleft()
    if pos == target:
      return step
    
    for neighbor in graph[pos]:
      if not visited[neighbor]:
        visited[neighbor] = True
        q.append((neighbor, step + 1))
  return -1

print(bfs(start, end))