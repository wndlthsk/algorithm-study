N = int(input())
SIDE = 10
graph = [[0] * 100 for _ in range(100)]

for _ in range(N):
  x, y = map(int, input().split())
  for r in range(y, y + SIDE):
    for c in range(x, x + SIDE):
      if not graph[r][c]:
        graph[r][c] = 1

rows = [sum(row) for row in graph]
print(sum(rows))