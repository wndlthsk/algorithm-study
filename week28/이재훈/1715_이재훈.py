import heapq

N = int(input())
heap = [int(input()) for _ in range(N)]
heapq.heapify(heap)

res = 0
while len(heap) > 1:
  a = heapq.heappop(heap)
  b = heapq.heappop(heap)
  cost = a + b
  res += cost
  heapq.heappush(heap, cost)
print(res)
