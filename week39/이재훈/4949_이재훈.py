import sys

for line in sys.stdin:
  if line.strip() == '.':
    break

  stk = []
  ok = True

  for ch in line:
    if ch == '(' or ch == '[':
      stk.append(ch)

    elif ch == ')':
      if not stk or stk[-1] != '(':
        ok = False
        break
      stk.pop()

    elif ch == ']':
      if not stk or stk[-1] != '[':
        ok = False
        break
      stk.pop()

  if ok and not stk:
    print("yes")
  else:
    print("no")