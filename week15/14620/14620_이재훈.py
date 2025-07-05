N = int(input())

board = [list(map(int, input().split())) for _ in range(N)]

# 꽃 하나가 차지하는 좌표
def get_flower_area(x, y):
  return {(x, y), (x+1, y), (x-1, y), (x, y+1), (x, y-1)}

# 꽃 하나의 비용
def get_cost(x, y):
  return board[x][y] + board[x+1][y] + board[x-1][y] + board[x][y+1] + board[x][y-1]

# 가능한 중심 좌표 목록
positions = [(i, j) for i in range(1, N-1) for j in range(1, N-1)]
lengths = len(positions)

min_cost = float('inf')
for i in range(lengths):
  x1, y1 = positions[i]
  area1 = get_flower_area(x1, y1)

  for j in range(i + 1, lengths):
    x2, y2 = positions[j]
    area2 = get_flower_area(x2, y2)

    if area1 & area2: # 겹치는 경우
      continue

    for k in range(j + 1, lengths):
      x3, y3 = positions[k]
      area3 = get_flower_area(x3, y3)

      if area1 & area3 or area2 & area3: # 겹치는 경우
        continue

      total_cost = get_cost(x1, y1) + get_cost(x2, y2) + get_cost(x3, y3)
      min_cost = min(min_cost, total_cost)

print(min_cost)
