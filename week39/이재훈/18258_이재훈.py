from collections import deque
import sys
input = sys.stdin.readline

N = int(input())

q = deque()
d = {
  'push': lambda x: q.append(x),
  'pop': lambda: q.popleft() if q else -1,
  'size': lambda: len(q),
  'empty': lambda: 1 if not q else 0,
  'front': lambda: q[0] if q else -1,
  'back': lambda: q[-1] if q else -1,
}

for _ in range(N):
  line = input().split()
  cmd = line[0]
  if cmd == 'push':
    d[cmd](line[1])
  else:
    print(d[cmd]())