N = int(input())
cnt = 0

for _ in range(N):
  line = input()
  seen = set()
  prev = ''
  is_group = True
  for ch in line:
    if ch != prev:
      if ch in seen:
        is_group = False
        break
      seen.add(ch)
    prev = ch
  if is_group:
    cnt += 1

print(cnt)
