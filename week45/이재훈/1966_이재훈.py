from collections import deque

T = int(input())
for _ in range(T):
  N, M = map(int, input().split())
  weights = list(map(int, input().split()))
  
  q = deque(enumerate(weights))
  
  order = 0
  while q:
    max_w = float('-inf')
    for _, w in q:
      max_w = max(max_w, w)
    
    if q[0][1] == max_w:
      idx, w = q.popleft()
      order += 1
      
      if idx == M:
        print(order)
        break
    else:
      q.append(q.popleft())