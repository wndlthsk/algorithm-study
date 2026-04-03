s = input().strip()

visited = set()

while True:
  if s in visited:
    print("FA")
    break
  visited.add(s)
  s = str(len(s))
  if s == "1":
    print("FA")
    break