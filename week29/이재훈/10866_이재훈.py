from collections import deque
import sys
input = sys.stdin.readline
N = int(input())

q = deque()
cmd = {
  'push_front': lambda x: q.appendleft(x),
  'push_back': lambda x: q.append(x),
  'pop_front': lambda: q.popleft() if q else -1,
  'pop_back': lambda: q.pop() if q else -1,
  'size': lambda: len(q),
  'empty': lambda: 0 if q else 1,
  'front': lambda: q[0] if q else -1,
  'back': lambda: q[-1] if q else -1,
}

for _ in range(N):
  line = input().split()
  if 'push' in line[0]:
    if 'front' in line[0]:
      cmd['push_front'](line[1])
    else:
      cmd['push_back'](line[1])
  else:
    print(cmd[line[0]]())
