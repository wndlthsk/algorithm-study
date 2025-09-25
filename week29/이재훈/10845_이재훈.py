from collections import deque
import sys
input = sys.stdin.readline
N = int(input())

q = deque()
cmd = {
  'push': lambda x: q.append(x),
  'pop': lambda: q.popleft() if q else -1,
  'size': lambda: len(q),
  'empty': lambda: 0 if q else 1,
  'front': lambda: q[0] if q else -1,
  'back': lambda: q[-1] if q else -1,
}

for i in range(N):
  line = input().split()
  if line[0] == 'push':
    cmd['push'](line[1])
  else:
    print(cmd[line[0]]())