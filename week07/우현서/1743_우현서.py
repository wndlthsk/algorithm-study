import sys
from collections import defaultdict, deque

def bfs(s, visited):
    q = deque([(s, 0)])
    visited[s] = True
    total = 0

    while q:
        s, depth = q.popleft()
        for x in friends[s]:
            if not visited[x] and depth+1 <= 2:
                visited[x] = True
                q.append((x, depth+1))
                total += 1

    return total


n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

friends = defaultdict(list)
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    friends[a].append(b)
    friends[b].append(a)

# print(friends)
visited = [False] * (n+1)
print(bfs(1, visited))
