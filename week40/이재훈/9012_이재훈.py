T = int(input())
for _ in range(T):
  line = list(input())
  
  stk = []
  for ch in line:
    stk.append(ch)
    
    if stk[-2:] == ['(', ')']:
      stk.pop()
      stk.pop()
  
  if not stk:
    print('YES')
  else:
    print('NO')