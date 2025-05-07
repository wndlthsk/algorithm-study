import sys
from collections import deque

n = int(sys.stdin.readline())
queue = deque()
for i in range(1, n+1):
    queue.append(i)
# print(queue)

while queue:
    now = queue.popleft()
    if queue:
        next = queue.popleft()
        queue.append(next)
    else:
        print(now)
