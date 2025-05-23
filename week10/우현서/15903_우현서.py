import sys, heapq

n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
heapq.heapify(a)
# print(a)
for i in range(m):
    x = heapq.heappop(a)
    y = heapq.heappop(a)
    heapq.heappush(a, x+y)
    heapq.heappush(a, x+y)

print(sum(a))