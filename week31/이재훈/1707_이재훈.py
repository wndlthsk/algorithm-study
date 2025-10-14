import sys
from collections import deque

input = sys.stdin.readline

def bfs(start, graph, colors):
  q = deque([start])
  colors[start] = 1  # 시작 노드는 1(빨강)
  
  while q:
    cur = q.popleft()
    for nxt in graph[cur]:
      if colors[nxt] == 0:  # 아직 방문하지 않았다면
        colors[nxt] = -colors[cur]  # 현재 노드와 다른 색으로 칠하기
        q.append(nxt)
      elif colors[nxt] == colors[cur]:  # 같은 색이라면 이분 그래프 X
        return False
  return True

K = int(input())
for _ in range(K):
  V, E = map(int, input().split())
  graph = [[] for _ in range(V + 1)]
  
  for _ in range(E):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
  
  # 색상 배열 (0: 방문 안 함, 1: 빨강, -1: 파랑)
  colors = [0] * (V + 1)
  is_bipartite = True

  for i in range(1, V + 1):
    if colors[i] == 0:  # 방문하지 않은 컴포넌트만 검사
      if not bfs(i, graph, colors):
        is_bipartite = False
        break

  print("YES" if is_bipartite else "NO")