import sys
sys.setrecursionlimit(10**6)

V = int(input())
graph = {i: [] for i in range(1, V + 1)}

for _ in range(V):
  data = list(map(int, input().split()))
  u = data[0]
  i = 1
  while data[i] != -1:
    v = data[i]
    w = data[i + 1]
    graph[u].append((v, w))
    i += 2

# DFS: node에서 subtree 최대 거리와 현재 subtree 지름을 반환
def dfs(node, parent):
  max1, max2 = 0, 0  # 서브트리 최대 거리 두 개
  diameter = 0        # 현재 서브트리 내 지름

  for nxt, w in graph[node]:
    if nxt != parent:
      child_dist, child_diameter = dfs(nxt, node)
      child_dist += w  # 현재 노드까지 거리 포함
      # 최대 거리 두 개 갱신
      if child_dist > max1:
        max1, max2 = child_dist, max1
      elif child_dist > max2:
        max2 = child_dist
      # 서브트리 지름 갱신
      diameter = max(diameter, child_diameter)

  # 현재 노드를 거쳐가는 경로가 지름인지 확인
  diameter = max(diameter, max1 + max2)
  return max1, diameter

_, tree_diameter = dfs(1, -1)
print(tree_diameter)