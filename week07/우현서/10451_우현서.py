import sys
from collections import deque

def bfs(s):
    q = deque([s])
    visited[s] = 1

    while q:
        now = q.popleft()
        next = numbers[now]
        if visited[next] == 0:
            q.append(next)
            visited[next] = 1


t = int(sys.stdin.readline())

for _ in range(t):
    n = int(sys.stdin.readline())
    numbers = [0] + list(map(int, sys.stdin.readline().split()))

    count = 0
    visited = [0] * (n + 1)
    for i in range(1, n+1):
        if visited[i] == 0:
            bfs(i)
            count += 1

    print(count)