import sys
input = sys.stdin.readline

N = int(input())
numbers = list(enumerate(map(int, input().split()), start=1))

res = []
idx = 0

while numbers:
  num, move = numbers.pop(idx)
  res.append(num)

  if not numbers:
    break

  if move > 0:
    idx = (idx + move - 1) % len(numbers)
  else:
    idx = (idx + move) % len(numbers)
print(*res)