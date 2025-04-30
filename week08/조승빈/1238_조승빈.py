import heapq
import sys
input = sys.stdin.readline
n,m,x = map(int,input().split(" "))
graph = {}
reverse_graph = {}
for i in range(1,n+1):
    graph[i] = []
    reverse_graph[i] = []

for _ in range(m):
    start,end,cost = map(int,input().split(" "))
    graph[start].append((end,cost))
    reverse_graph[end].append((start,cost))
heap = []

distance = [999999999999999] * (n+1)
reverse_distance = [999999999999999] * (n+1)

distance[x] = 0
reverse_distance[x] = 0
heapq.heappush(heap,(x,0))
while heap:
    node,cost = heapq.heappop(heap)
    if distance[node] < cost :
        continue
    for i in graph[node]:
        nextNode,cost = i
        if distance[node] + cost < distance[nextNode]:
            distance[nextNode] = distance[node] + cost 
            heapq.heappush(heap,(nextNode,distance[nextNode]))

heapq.heappush(heap,(x,0))
while heap:
    node,cost = heapq.heappop(heap)
    if reverse_distance[node] < cost :
        continue
    for i in reverse_graph[node]:
        nextNode,cost = i
        if reverse_distance[node] + cost < reverse_distance[nextNode]:
            reverse_distance[nextNode] = reverse_distance[node] + cost 
            heapq.heappush(heap,(nextNode,reverse_distance[nextNode]))            

answer = 0
for i in range(1,n+1):
    answer = max(answer,distance[i]+reverse_distance[i])
print(answer)


