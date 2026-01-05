N = int(input())
sources = []
for _ in range(N):
  sources.append(list(map(int, input().split())))

diff = float('inf')
visited = [False] * (N + 1)

def cal_select_node_diff():
  s, b = 1, 0
  selected = False

  for i in range(1, N + 1):
    if visited[i]:
      selected = True
      x, y = sources[i - 1]
      s *= x
      b += y

  if not selected:
    return float('inf')

  return abs(s - b)

def dfs(node):
  global diff

  visited[node] = True
  diff = min(diff, cal_select_node_diff())

  for nxt in range(node + 1, N + 1):
    if not visited[nxt]:
      dfs(nxt)

  visited[node] = False

for i in range(1, N + 1):
  dfs(i)

print(diff)