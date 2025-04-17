import heapq
import sys

input = sys.stdin.read

data = input().split()
n, m = int(data[0]), int(data[1])
graph = [[] for _ in range(n + 1)]
idx = 2
for _ in range(m):
    a = int(data[idx])
    b = int(data[idx + 1])
    c = int(data[idx + 2])
    graph[a].append((b, c))
    graph[b].append((a, c))
    idx += 3

dist = [float('inf')] * (n + 1)
dist[1] = 0
pq = [(0, 1)]  

while pq:
    cost, node = heapq.heappop(pq)
    if cost > dist[node]:
        continue
    for neighbor, weight in graph[node]:
        new_cost = cost + weight
        if new_cost < dist[neighbor]:
            dist[neighbor] = new_cost
            heapq.heappush(pq, (new_cost, neighbor))

print(dist[n])
