import sys
input = sys.stdin.readline

N, M, B = map(int, input().split())

freq = [0] * 257
max_h = 0
min_h = 256

for _ in range(N):
  row = list(map(int, input().split()))
  for h in row:
    freq[h] += 1
    max_h = max(max_h, h)
    min_h = min(min_h, h)

best_time = float('inf')
best_height = 0

for target in range(min_h, max_h + 1):
  remove = 0
  add = 0

  for h in range(min_h, max_h + 1):
    if freq[h] == 0:
      continue

    if h > target:
      remove += (h - target) * freq[h]
    elif h < target:
      add += (target - h) * freq[h]

  if remove + B < add:
    continue

  time = remove * 2 + add

  if time < best_time or (time == best_time and target > best_height):
    best_time = time
    best_height = target

print(best_time, best_height)