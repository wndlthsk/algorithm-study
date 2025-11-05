MOEUM = 'aeiou'

while True:
  line = input().split()
  if line[0] == '#':
    break
  
  cnt = 0
  for x in line:
    if not x.islower():
      x = x.lower()
    for ch in x:
      if ch in MOEUM:
        cnt += 1
  print(cnt)
