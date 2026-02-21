from collections import deque

T = int(input())
for _ in range(T):
  N, M = map(int, input().split())
  file_weights = list(map(int, input().split()))
  
  q = deque(enumerate(file_weights))
  order = 0
  while q:
    if q[0][1] >= max(q, key=lambda x: x[1])[1]:
      idx, weight = q.popleft()
      order += 1
      
      if idx == M:
        print(order)
        break
    else:
      q.append(q.popleft())