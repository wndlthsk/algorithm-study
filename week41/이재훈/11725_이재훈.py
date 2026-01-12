import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
N = int(input())

graph = {i: [] for i in range(1, N + 1)}
for _ in range(N - 1):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

visited = [False] * (N + 1)
parent = [0] * (N + 1)
def find_parent_node(prev):
  visited[prev] = True
  for nxt in graph[prev]:
    if not visited[nxt]:
      parent[nxt] = prev
      find_parent_node(nxt)

find_parent_node(1)
print('\n'.join(map(str, parent[2:])))