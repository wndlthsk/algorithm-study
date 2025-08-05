N, M = map(int, input().split())
seq = sorted(map(int, input().split()))  # 사전 순 출력을 위해 정렬

visited = [False] * N
result = []

def dfs(path):
  if len(path) == M:
    print(' '.join(map(str, path)))
    return

  prev = 0  # 중복 제거를 위한 값 추적
  for i in range(N):
    if not visited[i] and seq[i] != prev:
      visited[i] = True
      path.append(seq[i])
      dfs(path)
      path.pop()
      visited[i] = False
      prev = seq[i]
dfs([])