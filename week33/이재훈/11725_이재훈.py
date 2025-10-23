from collections import deque

N = int(input())
graph = {i: [] for i in range(1, N + 1)}
for _ in range(N - 1):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

parent = [0] * (N + 1)

def bfs(start):
  q = deque([start])
  while q:
    node = q.popleft()
    for nxt in graph[node]:
      if parent[nxt] == 0:     # 아직 부모가 정해지지 않은 노드라면
        parent[nxt] = node   # 현재 node가 부모
        q.append(nxt)

bfs(1)
for i in range(2, N + 1):
  print(parent[i])