import sys
input = sys.stdin.readline

N = int(input())

entered = set()
cnt = 0
for _ in range(N):
  a, b = map(int, input().split())
  if b == 1:
    if a in entered:
      cnt += 1
    else:
      entered.add(a)
  else:
    if a not in entered:
      cnt += 1
    else:
      entered.remove(a)

cnt += len(entered)
print(cnt)