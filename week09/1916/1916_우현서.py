import sys, heapq

# n개 도시, 도시-도시 m개 버스
# a도시 -> b도시 까지 버스 비용 최소 비용

def dijkstra(start):
    queue = [] # 다음 갈 노드
    heapq.heappush(queue, (0, start))
    cost[start] = 0
    while queue:
        now_cost, now_city = heapq.heappop(queue)
        if cost[now_city] < now_cost:
            continue
        for i in graph[now_city]:
            new_cost = now_cost + i[1]
            if new_cost < cost[i[0]]:
                cost[i[0]] = new_cost
                heapq.heappush(queue, (new_cost, i[0]))



n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)] # 연결된 노드
for _ in range(m):
    a, b, cost = map(int, sys.stdin.readline().split())
    graph[a].append((b, cost))
# print(bus)
a, b = map(int, sys.stdin.readline().split())

cost = [float('inf')] * (n+1) # 최소 비용 저장하는 리스트
# print(cost)
visited = [False] * (n+1)

dijkstra(a)
print(cost[b])