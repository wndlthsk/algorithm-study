import sys
input = sys.stdin.readline
N, M = map(int, input().split())
graph = {}

for _ in range(M):
  u, v = map(int, input().split())
  graph.setdefault(u, []).append(v)
  graph.setdefault(v, []).append(u)

for i in range(1, N + 1):
  if i not in graph:
    graph[i] = []
  else:
    graph[i].sort()  # 탐색 효율 향상

def dfs_stack(start, visited):
  stack = [start]
  visited[start] = True
  while stack:
    cur = stack.pop()
    for nxt in graph[cur]:
      if not visited[nxt]:
        visited[nxt] = True
        stack.append(nxt)

visited = [False] * (N + 1)
cnt = 0
for i in range(1, N + 1):
  if not visited[i]:
    dfs_stack(i, visited)
    cnt += 1
print(cnt)
