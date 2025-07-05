import sys
from collections import defaultdict, deque


def bfs(s, visited):
    q = deque([s])
    visited[s] = True
    count = 0
    while q:
        now = q.popleft()
        for next in computers[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
                count += 1
    return count


n, m = map(int, sys.stdin.readline().split())
computers = defaultdict(list)
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    # computers[a].append(b)
    computers[b].append(a)
# print(computers)

counts = []
for i in range(1, n+1):
    visited = [False] * (n+1)
    counts.append((i, bfs(i, visited)))

max_com = max(counts, key=lambda x: x[1])[1]
# print(max_com)
# print(counts)

result = []
for num, count in counts:
    if count == max_com:
        result.append(num)
result.sort()
print(*result)

