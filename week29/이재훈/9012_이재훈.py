T = int(input())
for _ in range(T):
  line = list(input())
  
  left = 0
  is_valid = True
  for x in line:
    if left < 0:
      is_valid = False
      break
    if x == '(':
      left += 1
    else:
      left -= 1
  
  if is_valid and left == 0:
    print('YES')
  else:
    print('NO')
