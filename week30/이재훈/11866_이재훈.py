from collections import deque
N, K = map(int, input().split())

res = []
start = 1
q = deque(range(1, N + 1))
for _ in range(N):
  q.rotate(-(K-1))
  res.append(q.popleft())
print(f"<{', '.join(map(str, res))}>")