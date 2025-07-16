N, M = map(int, input().split())

visited = [False] * (N + 1)

def dfs(start, path):
  if len(path) == M:
    print(' '.join(map(str, path)))
    return

  for i in range(start, N + 1):
    if not visited[i]:
      visited[i] = True
      dfs(i + 1, path + [i])
      visited[i] = False
dfs(1, [])