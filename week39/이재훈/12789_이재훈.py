from collections import deque

N = int(input())
q = deque(map(int, input().split()))
stk = []

target = 1

while q:
    if q[0] == target:
        q.popleft()
        target += 1
    else:
        stk.append(q.popleft())

    while stk and stk[-1] == target:
        stk.pop()
        target += 1

print("Nice" if target == N + 1 else "Sad")
