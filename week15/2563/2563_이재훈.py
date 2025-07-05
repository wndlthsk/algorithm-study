num = int(input())
pos = [list(map(int, input().split())) for _ in range(num)]

LEN = 10

visited = [[False] * 100 for _ in range(100)]

for x, y in pos:
  for i in range(LEN):
    for j in range(LEN):
      visited[x + i][y + j] = True
print(sum(row.count(True) for row in visited))