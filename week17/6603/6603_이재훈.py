def dfs(start, path, S):
  if len(path) == 6:
    print(' '.join(map(str, path)))
    return

  for i in range(start, len(S)):
    dfs(i + 1, path + [S[i]], S)

while True:
  line = list(map(int, input().split()))
  k = line[0]
  if k == 0:
    break
  S = line[1:]

  dfs(0, [], S)
  print()
