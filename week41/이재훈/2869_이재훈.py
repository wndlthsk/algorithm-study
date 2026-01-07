A, B, V = map(int, input().split())

day_sun = 1
height = A

diff = A - B
cnt = (V - height) // diff
remain = (V - height) % diff

if remain == 0:
  print(day_sun + cnt)
else:
  print(day_sun + cnt + 1)