N = int(input())
M = int(input())
broken = list(map(int, input().split()))

move = abs(100 - N)

def can_make(x):
  for ch in str(x):
    if int(ch) in broken:
      return False
  return True

for x in range(0, 1000001):
  if can_make(x):
    press = len(str(x))
    cost = abs(N - x)
    move = min(move, press + cost)
print(move)