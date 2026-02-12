import sys

MAX = 10_000
N = int(input())
num_freq = [0] * (MAX + 1)

for line in sys.stdin:
  num = int(line.rstrip())
  num_freq[num] += 1

for idx, cnt in enumerate(num_freq):
  if cnt > 0:
    for _ in range(cnt):
      sys.stdout.write(str(idx) + '\n')