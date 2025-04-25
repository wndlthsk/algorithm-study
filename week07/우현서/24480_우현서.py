import sys
sys.setrecursionlimit(10 ** 6)

def dfs(v):
    global count
    visited[v] = True
    count += 1
    result[v] = count

    for x in graph[v]:
        if not visited[x]:
           dfs(x)


n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
# print(graph)

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
for g in graph:
    g.sort(reverse=True)

visited = [False] * (n+1)
result = [0] * (n+1)
count = 0

dfs(r)

print(*result[1:], sep='\n')