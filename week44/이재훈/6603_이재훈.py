import sys

SELECT = 6

for l in sys.stdin:
  if l.rstrip() == '0':
    break
  
  line = list(map(int, l.split()))
  k = line[0]
  S = line[1:]
  
  visited = [False] * (k + 1)
  res = set()
  def dfs(total, cur_arr):
    if total == SELECT:
      res.add(tuple(sorted(cur_arr)))
      return
    
    for i in range(k):
      if not visited[i]:
        visited[i] = True
        dfs(total + 1, cur_arr + [S[i]])
        visited[i] = False
  dfs(0, [])
  
  for comb in sorted(res):
    print(*comb)
  print()