from collections import deque

def calMeter(r1, c1, r2, c2):
    return abs(r1 - r2) + abs(c1 - c2)

def toMap(lst):
    graph = []
    for el in lst:
        graph.append(list(el))
    return graph

def distance_in_2(i, j, graph):
    d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    q = deque([(i, j, 0)])
    visited = [[False] * 5 for _ in range(5)]
    visited[i][j] = True
    
    while q:
        x, y, distance = q.popleft()
        if distance != 0 and graph[x][y] == 'P':
            return True
        if distance == 2:
            continue
        
        for dx, dy in d:
            nx, ny = x + dx, y + dy
            if 0 <= nx < 5 and 0 <= ny < 5:
                if not visited[nx][ny] and graph[nx][ny] != 'X':
                    q.append((nx, ny, distance + 1))
                    visited[nx][ny] = True
    return False

def isSafeMeter(graph):
    for i in range(5):
        for j in range(5):
            if graph[i][j] == 'P':
                if distance_in_2(i, j, graph):
                    return 0
    return 1

def solution(places):
    res = []
    for place in places:
        graph = toMap(place)
        safe = isSafeMeter(graph)
        res.append(safe)
    return res