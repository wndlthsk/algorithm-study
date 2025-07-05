import sys, heapq

t = int(sys.stdin.readline())
for _ in range(t):
    k = int(sys.stdin.readline())
    min_heap = []
    max_heap = []
    valid = [False] * k

    for i in range(k):
        io, num = sys.stdin.readline().split()
        num = int(num)
        if io == 'I':
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))
            valid[i] = True

        elif io == 'D':
            if num == -1: # 최소 힙
                while min_heap and valid[min_heap[0][1]] == False: # 유효한 값을 꺼내야하므로
                    heapq.heappop(min_heap)
                if min_heap:
                    valid[min_heap[0][1]] = False
                    heapq.heappop(min_heap)
            elif num == 1: # 최대 힙
                while max_heap and valid[max_heap[0][1]] == False:  # 유효한 값을 꺼내야하므로
                    heapq.heappop(max_heap)
                if max_heap:
                    valid[max_heap[0][1]] = False
                    heapq.heappop(max_heap)

    # print(min_heap)
    # print(max_heap)
    # print()
    while min_heap and valid[min_heap[0][1]] == False:
        heapq.heappop(min_heap)
    while max_heap and valid[max_heap[0][1]] == False:
        heapq.heappop(max_heap)
    # print(min_heap)
    # print(max_heap)

    if min_heap and max_heap:
        print(-max_heap[0][0], min_heap[0][0])
    else:
        print("EMPTY")