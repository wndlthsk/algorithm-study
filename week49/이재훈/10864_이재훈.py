N, M = map(int, input().split())

graph = {i:[] for i in range(1, N + 1)}
for _ in range(M):
  A, B = map(int, input().split())
  graph[A].append(B)
  graph[B].append(A)

for i in range(1, N + 1):
  print(len(graph[i]))