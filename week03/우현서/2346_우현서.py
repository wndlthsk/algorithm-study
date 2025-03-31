import sys
from collections import deque

n = int(sys.stdin.readline())
balloon = list(map(int, sys.stdin.readline().split()))
q = deque()
for i in range(n):
    q.append([i+1, balloon[i]])
result = []
while q:
    now = q.popleft()
    result.append(now[0])

    if now[1] > 0:
        q.rotate(-(now[1]-1))
    elif now[1] < 0:
        q.rotate(-now[1])

print(' '.join(map(str, result)))
