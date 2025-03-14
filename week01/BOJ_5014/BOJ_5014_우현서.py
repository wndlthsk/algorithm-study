import sys
from collections import deque

# f: 총 층수/ s: 현재/ g: 목표/ u: 위/ d: 아래
f, s, g, u, d = map(int, sys.stdin.readline().split())

visited = [0] * (f+1)

visited[s] = 1
count = 0
check = 0
queue = deque([(s, count)])

while queue:
    now, count = queue.popleft()

    if now == g:
        check = 1
        print(count)
        break

    up = now + u
    if up <= f and visited[up] == 0:
        visited[up] = 1
        queue.append((up, count + 1))

    down = now - d
    if down > 0 and visited[down] == 0:
        visited[down] = 1
        queue.append((down, count + 1))

    # print(queue)
    # print(visited)
if check == 0:
    print('use the stairs')