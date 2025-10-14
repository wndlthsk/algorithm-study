T = int(input())
for _ in range(T):
  N = int(input())
  perms = [0] + list(map(int, input().split()))  # 1-indexed

  cnt = 0
  visited = [False] * (N + 1)
  for i in range(1, N + 1):
    if not visited[i]:
      cur = i
      while not visited[cur]:
        visited[cur] = True
        cur = perms[cur]
      cnt += 1
  print(cnt)