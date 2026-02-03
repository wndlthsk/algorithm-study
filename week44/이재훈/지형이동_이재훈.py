import heapq

def solution(land, height):
    N = len(land)
    visited = [[False] * N for _ in range(N)]
    pq = []
    pq.append((0, 0, 0))  # cost, y, x
    total = 0

    DIR = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while pq:
        cost, y, x = heapq.heappop(pq)

        if visited[y][x]:
            continue

        visited[y][x] = True
        total += cost

        for dy, dx in DIR:
            ny, nx = y + dy, x + dx
            if 0 <= ny < N and 0 <= nx < N:
                if not visited[ny][nx]:
                    diff = abs(land[ny][nx] - land[y][x])
                    next_cost = 0 if diff <= height else diff
                    heapq.heappush(pq, (next_cost, ny, nx))

    return total
