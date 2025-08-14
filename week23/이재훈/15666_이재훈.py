N, M = map(int, input().split())
seq = list(map(int, input().split()))

s = sorted(set(seq))
N = len(s)

def dfs(start, path):
  if len(path) == M:
    print(*path)
    return
  
  for i in range(start, N):
    dfs(i, path + [s[i]])
dfs(0, [])