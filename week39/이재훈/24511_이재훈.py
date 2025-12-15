from collections import deque
import sys
input = sys.stdin.readline

N = int(input())
types = list(map(int, input().split()))
values = list(map(int, input().split()))

dq = deque()

# queue(0) 인 것만 저장
for t, v in zip(types, values):
    if t == 0:
        dq.append(v)

M = int(input())
queries = list(map(int, input().split()))

res = []
for x in queries:
    dq.appendleft(x)
    res.append(dq.pop())

print(*res)
