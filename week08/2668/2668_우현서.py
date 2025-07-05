import sys

n = int(sys.stdin.readline())
numbers = [0]
for _ in range(n):
    numbers.append(int(sys.stdin.readline()))

result = set()
for i in range(1, n+1):
    visited = [False] * (n+1)
    stack = [i]
    path = []

    while stack:
        now = stack.pop()
        if visited[now]:
            continue
        visited[now] = True
        path.append(now)
        next = numbers[now]
        if not visited[next]:
            stack.append(next)
        elif next in path:
            index = path.index(next)
            result.update(path[index:])
            break

print(len(result))
for x in sorted(result):
    print(x)
# print(result)