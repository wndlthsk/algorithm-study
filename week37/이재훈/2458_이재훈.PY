import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
rev_graph = [[] for _ in range(N+1)]

for _ in range(M):
  a, b = map(int, input().split())
  graph[a].append(b)
  rev_graph[b].append(a)

def dfs(cur, g, visited):
  visited[cur] = True
  cnt = 1
  for nxt in g[cur]:
    if not visited[nxt]:
      cnt += dfs(nxt, g, visited)
  return cnt

answer = 0
for start in range(1, N+1):
  visited_f = [False] * (N + 1)
  visited_b = [False] * (N + 1)

  forward_count = dfs(start, graph, visited_f)
  backward_count = dfs(start, rev_graph, visited_b)

  bigger = forward_count - 1
  smaller = backward_count - 1

  if bigger + smaller == N - 1:
    answer += 1
print(answer)