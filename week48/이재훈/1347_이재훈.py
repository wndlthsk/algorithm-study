import sys
input = sys.stdin.readline

N = int(input())
commands = input().strip()

dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]

dir = 0
x = y = 0

visited = set()
visited.add((x, y))

min_x = max_x = x
min_y = max_y = y

for c in commands:
  if c == 'R':
    dir = (dir + 1) % 4
  elif c == 'L':
    dir = (dir - 1) % 4
  else:
    x += dx[dir]
    y += dy[dir]
    visited.add((x, y))
    min_x = min(min_x, x)
    max_x = max(max_x, x)
    min_y = min(min_y, y)
    max_y = max(max_y, y)

H = max_x - min_x + 1
W = max_y - min_y + 1

maze = [['#'] * W for _ in range(H)]

for vx, vy in visited:
  maze[vx - min_x][vy - min_y] = '.'

for row in maze:
  print(''.join(row))