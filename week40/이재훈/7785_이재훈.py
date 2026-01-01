n = int(input())

logs = set()
for _ in range(n):
  name, io = input().split()
  if io == 'enter':
    logs.add(name)
  else:
    logs.discard(name)
print('\n'.join(sorted(logs, reverse=True)))