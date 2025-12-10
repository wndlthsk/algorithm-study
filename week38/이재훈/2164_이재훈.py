from collections import deque
N = int(input())

q = deque(range(1, N + 1))

while q:
  if len(q) == 1:
    print(q[0])
    break
  
  q.popleft()
  top = q.popleft()
  q.append(top)
