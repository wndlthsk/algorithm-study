import sys
from collections import deque

n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
C = list(map(int, sys.stdin.readline().split()))

queue = deque()
for i in range(n):
    if A[i] == 0:
        queue.append(B[i])
# print(queue)

result = []
for c in C:
    queue.appendleft(c)
    result.append(queue.pop())

print(*result)

# 스택인 경우 리턴 값이 최종 리턴 값이 되지 않으므로 큐인 경우만 고려하면 된다.
# 큐인 경우 기존 값을 리턴하고, 새로운 값을 큐에 저장함. -> appendleft하고, pop한 게 그 단계에서 최종 결과값