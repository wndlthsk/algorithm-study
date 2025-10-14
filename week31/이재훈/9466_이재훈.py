import sys
sys.setrecursionlimit(1000000)

T = int(input())

def dfs(node, arr, visited, finished, count):
  visited[node] = True
  next_node = arr[node]

  if not visited[next_node]:
    count = dfs(next_node, arr, visited, finished, count)
  elif not finished[next_node]:  # 사이클 발견
    temp = next_node
    while temp != node:
      count += 1
      temp = arr[temp]
    count += 1  # 자기 자신 포함

  finished[node] = True
  return count

for _ in range(T):
  n = int(input())
  numbers = list(map(int, input().split()))
  arr = [0] + numbers  # 1-index

  visited = [False] * (n + 1)
  finished = [False] * (n + 1)

  team_count = 0
  for i in range(1, n + 1):
    if not visited[i]:
      team_count = dfs(i, arr, visited, finished, team_count)

  print(n - team_count)