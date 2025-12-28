S = input()

stk = []
r_stk = []
is_tag = False

for ch in S:
  if ch == '<':
    while stk:
      r_stk.append(stk.pop())
    is_tag = True
    r_stk.append(ch)

  elif ch == '>':
    is_tag = False
    r_stk.append(ch)

  elif ch == ' ':
    if is_tag:
      r_stk.append(ch)
    else:
      while stk:
        r_stk.append(stk.pop())
      r_stk.append(ch)

  else:
    if is_tag:
      r_stk.append(ch)
    else:
      stk.append(ch)

while stk:
  r_stk.append(stk.pop())

print(''.join(r_stk))
