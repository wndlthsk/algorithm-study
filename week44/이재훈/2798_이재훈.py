N, M = map(int, input().split())
numbers = list(map(int, input().split()))

total = 0
visited = [False] * N
def dfs(cur):
  global total
  
  if len(cur) == 3:
    if total <= M:
      total = max(total, sum(cur))
      return
  
  for idx in range(N):
    if not visited[idx]:
      if sum(cur) + numbers[idx] <= M:
        visited[idx] = True
        dfs(cur + [numbers[idx]])
        visited[idx] = False

dfs([])

print(total)