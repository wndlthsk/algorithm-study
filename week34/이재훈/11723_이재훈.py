import sys
input = sys.stdin.readline

S = set()
dic = {
  'add': lambda x: S.add(x),
  'remove': lambda x: S.discard(x),
  'check': lambda x: print(1) if x in S else print(0),
  'toggle': lambda x: dic['remove'](x) if x in S else dic['add'](x),
  'all': lambda: S.update(range(1, 21)),
  'empty': lambda: S.clear(),
}

M = int(input())
for _ in range(M):
  line = input().split()
  if len(line) == 2:
    cmd, x = line[0], int(line[1])
    dic[cmd](x)
  else:
    cmd = line[0]
    dic[cmd]()