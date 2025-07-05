from collections import deque

T = int(input())

# 나이트가 이동할 수 있는 8가지 방향
can_go = [
  # 왼쪽 위
  (-1, -2), (-2, -1), 
  # 오른쪽 위
  (1, -2), (2, -1),
  # 왼쪽 아래
  (-2, 1), (-1, 2),
  # 오른쪽 아래
  (2, 1), (1, 2)
]

for i in range(T):
  N = int(input())
  current_x, current_y = map(int, input().split())
  will_go_x, will_go_y = map(int, input().split())
  
  # 도착 위치와 같으면 0 출력
  if (current_x, current_y) == (will_go_x, will_go_y):
    print(0)
    continue
  
  visited = [[False] * N for _ in range(N)]
  queue = deque()
  queue.append((current_x, current_y, 0))  # (x, y, 이동 횟수)
  visited[current_y][current_x] = True

  while queue:
    x, y, move_cnt = queue.popleft()

    for dx, dy in can_go:
      nx, ny = x + dx, y + dy

      if 0 <= nx < N and 0 <= ny < N and not visited[ny][nx]:
        if (nx, ny) == (will_go_x, will_go_y):
          print(move_cnt + 1)
          queue.clear()
          break
        visited[ny][nx] = True
        queue.append((nx, ny, move_cnt + 1))