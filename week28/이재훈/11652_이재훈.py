import sys
input = sys.stdin.readline

N = int(input())
count = {}

for _ in range(N):
  num = int(input())
  count[num] = count.get(num, 0) + 1

max_count = max(count.values())
candidates = [k for k, v in count.items() if v == max_count]
print(min(candidates))