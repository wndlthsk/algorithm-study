import sys
import heapq

input = sys.stdin.readline
n = int(input())
m = int(input())
graph = {}
for i in range(1,n+1):
    graph[i] = []
distance = [999999999999999] * (n+1)

for _ in range(m):
    start, end, cost = map(int, input().split())
    graph[start].append((end,cost))

start, end = map(int, input().split())
distance[start] = 0
q = [(0, start)]

while q:
    dist, now = heapq.heappop(q)
    if distance[now] < dist:
        continue
    for next_node, next_dist in graph[now]:
        cost = dist + next_dist
        if cost < distance[next_node]:
            distance[next_node] = cost
            heapq.heappush(q, (cost, next_node))

print(distance[end])
