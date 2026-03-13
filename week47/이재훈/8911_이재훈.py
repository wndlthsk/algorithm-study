T = int(input())
for _ in range(T):
  cmd = input()
  
  dir = 0
  pos_x, pos_y = 0, 0
  
  min_x = max_x = 0
  min_y = max_y = 0
  
  dx = [0, 1, 0, -1]
  dy = [1, 0, -1, 0]
  
  for c in cmd:
    if c == 'L':
      dir = (dir + 3) % 4
    elif c == 'R':
      dir = (dir + 1) % 4
    elif c == 'F':
      pos_x += dx[dir]
      pos_y += dy[dir]
    elif c == 'B':
      pos_x -= dx[dir]
      pos_y -= dy[dir]
    
    min_x = min(min_x, pos_x)
    max_x = max(max_x, pos_x)
    min_y = min(min_y, pos_y)
    max_y = max(max_y, pos_y)

  print((max_x - min_x) * (max_y - min_y))