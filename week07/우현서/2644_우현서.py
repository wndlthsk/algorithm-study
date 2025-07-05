import sys
from collections import deque, defaultdict


def bfs(s, e, visited):
    visited[s] = 1
    q = deque([(s, 0)])

    while q:
        now, count = q.popleft()
        if now == e:
            return count
        if graph[now]:
            # print(now, graph[now])
            for i in graph[now]:
                if visited[i] == 0:
                    visited[i] = 1
                    q.append((i, count+1))

    return -1


n = int(sys.stdin.readline())
a, b = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())
graph = defaultdict(list)
for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)
# print(graph)

visited = [0] * (n+1)
print(bfs(a, b, visited))