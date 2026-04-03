from collections import deque

A, B = map(int, input().split())

q = deque([(A, 1)])

while q:
  x, cnt = q.popleft()
  
  if x == B:
    print(cnt)
    break
  
  if x * 2 <= B:
    q.append((x * 2, cnt + 1))
  
  if int(str(x) + '1') <= B:
    q.append((int(str(x) + '1'), cnt + 1))
else:
  print(-1)