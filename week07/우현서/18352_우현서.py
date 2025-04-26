import sys
from collections import defaultdict, deque


def bfs(s, visited):
    visited[s] = True
    q = deque([(s, 0)])

    while q:
        now, cnt = q.popleft()
        if cnt == k:
            result.append(now)
            continue
        for node in graph[now]:
            if not visited[node]:
                q.append((node, cnt+1))
                visited[node] = True


n, m, k, x = map(int, sys.stdin.readline().split())
graph = defaultdict(list)
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

visited = [False] * (n+1)
result = []
bfs(x, visited)


if result:
    result.sort()
    print(*result, sep='\n')
else:
    print(-1)
