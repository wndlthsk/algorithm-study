N, M = map(int, input().split())
visited = [False] * (N + 1)
seq = []

def backtrack():
  if len(seq) == M:
    print(' '.join(map(str, seq)))
    return

  for i in range(1, N + 1):
    if not visited[i]:
      visited[i] = True
      seq.append(i)
      backtrack()
      seq.pop()
      visited[i] = False

backtrack()