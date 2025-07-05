N = int(input())

is_valid = False
cnt = 0
while N >= 0:
  if N % 5 == 0:
    cnt += N // 5
    is_valid = True
    break
  N -= 3
  cnt += 1

if is_valid:
  print(cnt)
else:
  print(-1)
