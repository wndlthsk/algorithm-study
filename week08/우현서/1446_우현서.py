import sys, heapq
n, d = map(int, sys.stdin.readline().split())

distance = [float('inf')] * (d+1) # 각 노드까지의 거리 배열, 무한으로 초기화
def dijkstra():
    distance[0] = 0 # 시작위치에서 거리는 0
    queue = [] # 우선순위 큐->최소 힙, (누적 거리, 현재 위치), 가장 거리가 적은 경로부터 처리
    heapq.heappush(queue, (0, 0))

    while queue:
        dist, now = heapq.heappop(queue) # 현재까지의 거리와 현재 위치

        if distance[now] < dist: # 이미 더 짧은 길로 왔다면 건너뜀
            continue

        for next_node, next_dist in graph[now]:
            new_dist = dist + next_dist
            if distance[next_node] > new_dist:
                distance[next_node] = new_dist
                heapq.heappush(queue, (new_dist, next_node))


graph = [[] for _ in range(d + 1)]
for i in range(d):
    graph[i].append((i+1, 1))

for _ in range(n):
    s, e, l = map(int, sys.stdin.readline().split())
    if e > d or (e-s) <= l:
        continue
    graph[s].append((e, l))

# print(graph)
dijkstra()
print(distance[d])