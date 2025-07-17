N, M = map(int, input().split())

def dfs(path):
  if len(path) == M:
    print(' '.join(map(str, path)))
    return

  for i in range(1, N + 1):
    dfs(path + [i])
dfs([])