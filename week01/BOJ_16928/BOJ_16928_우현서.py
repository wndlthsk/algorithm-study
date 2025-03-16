import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
ladders = {start: end for start, end in (map(int, sys.stdin.readline().split()) for _ in range(n))}
snakes = {start: end for start, end in (map(int, sys.stdin.readline().split()) for _ in range(m))}

visited = [0] * 101
count = 0
queue = deque([(1, count)])
visited[1] = 1

while queue:
    now, count = queue.popleft()
    if now == 100:
        break
    for i in range(1, 7):
        next = now + i

        if next <= 100 and visited[next] == 0:
            if next in ladders:
                next = ladders[next]
            elif next in snakes:
                next = snakes[next]

            if visited[next] == 0:
                visited[next] = 1
                queue.append((next, count+1))
        else:
            continue

print(count)
