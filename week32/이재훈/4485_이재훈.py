import heapq
import sys
input = sys.stdin.readline

d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

problem = 1
while True:
  N = int(input())
  if N == 0: break

  board = [list(map(int, input().split())) for _ in range(N)]
  dist = [[float('inf')] * N for _ in range(N)]
  dist[0][0] = board[0][0]

  q = []
  heapq.heappush(q, (board[0][0], 0, 0))  # (비용, x, y)

  while q:
    cost, x, y = heapq.heappop(q)

    if dist[x][y] < cost:
      continue

    for dx, dy in d:
      nx, ny = x + dx, y + dy
      if 0 <= nx < N and 0 <= ny < N:
        new_cost = cost + board[nx][ny]
        if new_cost < dist[nx][ny]:
          dist[nx][ny] = new_cost
          heapq.heappush(q, (new_cost, nx, ny))

  print(f"Problem {problem}: {dist[N - 1][N - 1]}")
  problem += 1