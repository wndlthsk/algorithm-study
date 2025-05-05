import sys, heapq
n, m, x = map(int, sys.stdin.readline().split())

def dijkstra(start, g):
    times = [float('inf')] * (n + 1)
    times[start] = 0
    queue = []
    heapq.heappush(queue, (0, start)) # 시간, 노드

    while queue:
        time, now = heapq.heappop(queue)

        if times[now] < time:
            continue

        for next_node, next_time in g[now]:
            new_time = time + next_time
            if times[next_node] > new_time:
                times[next_node] = new_time
                heapq.heappush(queue, (new_time, next_node))

    return times

graph = [[] for _ in range(n + 1)]
reverse_graph = [[] for _ in range(n + 1)] # x에서 모든 노드까지의 거리를 위한 그래프
for _ in range(m):
    s, e, t = map(int, sys.stdin.readline().split())
    graph[s].append((e, t))
    reverse_graph[e].append((s, t))
# print(graph)

go = dijkstra(x, reverse_graph) # i->x까지 최단 시간, 모든 마을에서 x까지의 최단 시간
back = dijkstra(x, graph) # x-> i까지 최단 시간

result = []
for i in range(1, n+1):
    # result.append(dijkstra(i, x) + dijkstra(x, i)) # 2n번의 다익스트라 수행 -> 2번 수행
    result.append(go[i] + back[i])

print(max(result))