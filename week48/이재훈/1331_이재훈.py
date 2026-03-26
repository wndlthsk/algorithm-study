moves = [input().strip() for _ in range(36)]

visited = set()
dirs = [(-2,-1),(-2,1),(2,-1),(2,1),(-1,-2),(-1,2),(1,-2),(1,2)]

def valid(a, b):
  ax = ord(a[0]) - ord('A')
  ay = int(a[1]) - 1
  bx = ord(b[0]) - ord('A')
  by = int(b[1]) - 1

  return (abs(ax-bx), abs(ay-by)) in [(2,1),(1,2)]

prev = moves[0]
visited.add(prev)

ok = True

for i in range(1, 36):
  cur = moves[i]
  if cur in visited or not valid(prev, cur):
    ok = False
    break
  visited.add(cur)
  prev = cur

if ok and valid(moves[-1], moves[0]):
  print("Valid")
else:
  print("Invalid")