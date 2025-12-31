while True:
  line = input()
  if line == '#':
    break
  
  cnt = 0
  for ch in line:
    if ch in 'aeiouAEIOU':
      cnt += 1
  print(cnt)