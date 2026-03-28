from collections import deque

N = int(input())
q = deque(map(int, input().split()))
stk = []

target = 1

while q or stk:
  while stk and stk[-1] == target:
    stk.pop()
    target += 1
  
  if q and q[0] == target:
    q.popleft()
    target += 1
  elif q:
    stk.append(q.popleft())
  else:
    break

print("Nice" if target == N + 1 else "Sad")