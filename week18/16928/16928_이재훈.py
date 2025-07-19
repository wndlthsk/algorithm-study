from collections import deque

N, M = map(int, input().split())

board = [i for i in range(101)]  # 0~100, board[i] = i가 기본값

# 사다리 + 뱀 정보 반영
for _ in range(N + M):
  x, y = map(int, input().split())
  board[x] = y

visited = [False] * 101

def bfs():
  q = deque()
  q.append((1, 0))
  visited[1] = True

  while q:
    pos, cnt = q.popleft()

    if pos == 100:
      print(cnt)
      return

    for dice in range(1, 7):
      next_pos = pos + dice
      if next_pos > 100:
        continue

      dest = board[next_pos]  # 뱀/사다리 반영
      if not visited[dest]:
        visited[dest] = True
        q.append((dest, cnt + 1))
bfs()

# BFS는 한 번 방문한 노드에 처음 도달한 경로가 항상 최단 경로
# 따라서, visited 배열은 필수임.