import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, R, Q = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(N - 1):
  u, v = map(int, input().split())
  graph[u].append(v)
  graph[v].append(u)

subtree = [0] * (N + 1)

def dfs(node, parent):
  subtree[node] = 1
  for nxt in graph[node]:
    if nxt != parent:
      dfs(nxt, node)
      subtree[node] += subtree[nxt]

dfs(R, 0)

for _ in range(Q):
  u = int(input())
  print(subtree[u])