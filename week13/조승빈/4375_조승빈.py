import sys
from collections import deque

def bfs(n):
    visited = set()
    q = deque()
    q.append(('1', 1 % n))

    while q:
        s, r = q.popleft()
        if r == 0:
            return len(s)
        if r not in visited:
            visited.add(r)
            q.append((s + '1', (r * 10 + 1) % n))

for line in sys.stdin:
    line = line.strip()
    if not line:
        continue
    n = int(line)
    print(bfs(n))
