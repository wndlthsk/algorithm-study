import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

q = deque()
dic = {
  1: lambda x: q.appendleft(x),
  2: lambda x: q.append(x),
  3: lambda: q.popleft() if q else -1,
  4: lambda: q.pop() if q else -1,
  5: lambda: len(q),
  6: lambda: 1 if not q else 0,
  7: lambda: q[0] if q else -1,
  8: lambda: q[-1] if q else -1,
}

for _ in range(N):
  line = input().split()
  cmd = int(line[0])
  
  if cmd in [1, 2]:
    x = line[1]
    dic[cmd](x)
    continue
  
  print(dic[cmd]())