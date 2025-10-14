from collections import deque
N, M, V = map(int, input().split())
graph = {i: [] for i in range(1, N + 1)}

for _ in range(M):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

# 정점 번호가 작은 순서대로 방문해야 함
for k in graph:
  graph[k].sort()


def dfs(v, visited):
  visited[v] = True
  print(v, end=' ')
  for nxt in graph[v]:
    if not visited[nxt]:
      dfs(nxt, visited)


def bfs(v):
  visited = [False] * (N + 1)
  q = deque([v])
  visited[v] = True

  while q:
    cur = q.popleft()
    print(cur, end=' ')
    for nxt in graph[cur]:
      if not visited[nxt]:
        visited[nxt] = True
        q.append(nxt)

visited = [False] * (N + 1)
dfs(V, visited)
print()
bfs(V)