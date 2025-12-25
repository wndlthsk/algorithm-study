from collections import deque
N = int(input())

if N == 1:
  print(1)
  exit()

q = deque(range(1, N + 1))

while True:
  q.popleft()
  if len(q) == 1:
    print(q[0])
    break
  
  x = q.popleft()
  q.append(x)