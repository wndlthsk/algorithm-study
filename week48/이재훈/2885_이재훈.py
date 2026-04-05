import sys
input = sys.stdin.readline

K = int(input())

size = 1
while size < K:
  size *= 2

cnt = 0
temp = size
while K > 0:
  if K >= temp:
    K -= temp
  else:
    temp //= 2
    cnt += 1
print(size, cnt)