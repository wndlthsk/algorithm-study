N = int(input())
dots = [list(map(int, input().split())) for _ in range(N)]

left, right = float('inf'), float('-inf')
top, bottom = float('-inf'), float('inf')
for x, y in dots:
  if x < left:
    left = x
  if x > right:
    right = x
  if y > top:
    top = y
  if y < bottom:
    bottom = y

dx = right -left
dy = top - bottom
print(dx * dy)