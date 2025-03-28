import sys
n = int(sys.stdin.readline())
heights = []
max_x = 0
max_height = 0
for i in range(n):
    l, h = map(int, sys.stdin.readline().split())
    heights.append([l, h])
    if h > max_height:
        max_height = h
        max_x = l
heights.sort()
max_idx = heights.index([max_x, max_height])

# 가장 높은 기둥 기준 왼쪽 넓이
now = 0
result = 0
for i in range(max_idx):
    now = max(now, heights[i][1])
    result += now * (heights[i+1][0] - heights[i][0])

# 가장 높은 기둥 기준 오른쪽 넓이
now = 0
for i in range(n-1, max_idx, -1):
    now = max(now, heights[i][1])
    result += now * (heights[i][0] - heights[i-1][0])

result += max_height
print(result)

