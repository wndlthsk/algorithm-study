N, M = map(int, input().split())
seq = list(map(int, input().split()))

s = sorted(set(seq))
N = len(s)

def dfs(path):
  if len(path) == M:
    print(' '.join(map(str, path)))
    return
  
  for i in range(N):
    dfs(path + [s[i]])
dfs([])