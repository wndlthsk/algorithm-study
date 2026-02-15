import sys

for line in sys.stdin:
  l = list(line)
  sm, bg, num, space = 0, 0, 0, 0
  for ch in l:
    if ch.islower():
      sm += 1
      continue
    elif ch.isupper():
      bg += 1
      continue
    elif ch.isdigit():
      num += 1
      continue
    elif ch == ' ':
      space += 1
      continue
  print(sm, bg, num, space)