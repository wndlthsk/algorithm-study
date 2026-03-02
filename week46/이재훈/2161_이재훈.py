from collections import deque

N = int(input())

q = deque(range(1, N + 1))

res = []
while len(q) > 1:
  trash = q.popleft()
  res.append(trash)
  
  q.append(q.popleft())
print(*res, q[0])