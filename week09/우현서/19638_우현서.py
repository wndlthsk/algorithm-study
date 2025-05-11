import sys, heapq

popularity, h_centi, t = map(int, sys.stdin.readline().split())
heights = [-int(sys.stdin.readline()) for _ in range(popularity)]
heapq.heapify(heights)
hammer_cnt = 0

for _ in range(t):
    height = -heights[0]
    if height == 1 or height < h_centi:
        break
    else:
        hammer_cnt += 1
        heapq.heapreplace(heights, -(height // 2))

if h_centi <= -heights[0]:
    print("NO")
    print(-heapq.heappop(heights))
else:
    print("YES")
    print(hammer_cnt)