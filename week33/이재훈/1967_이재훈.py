import sys
sys.setrecursionlimit(10**6)

n = int(input())
graph = {}
for _ in range(n - 1):
  parent, child, weight = map(int, input().split())
  graph.setdefault(parent, []).append((child, weight))
  graph.setdefault(child, []).append((parent, weight))

dist = 0
def dfs(node, backword):
  global dist
  longest, longer = 0, 0
  
  for nxt, w in graph.get(node, []):
    if nxt == backword:
      continue
    child_dist = dfs(nxt, node) + w
    if child_dist > longest:
      longest, longer = child_dist, longest
    elif child_dist > longer:
      longer = child_dist
  
  dist = max(dist, longest + longer)
  return longest

dfs(1, -1)
print(dist)