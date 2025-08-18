N, S, M = map(int, input().split())
Vi = list(map(int, input().split()))

visited = [[False] * (M + 1) for _ in range(N + 1)]
res = -1
def dfs(order, cur_vol):
  global res
  if not (0 <= cur_vol <= M):
    return
  if visited[order][cur_vol]:
    return
  visited[order][cur_vol] = True

  if order == N:  # 모든 곡 다 탐색
    res = max(res, cur_vol)
    return

  dfs(order + 1, cur_vol + Vi[order])
  dfs(order + 1, cur_vol - Vi[order])
dfs(0, S)
print(res)
