string = input()
bomb = input()
bl = len(bomb)

stack = []

for ch in string:
  stack.append(ch)
  
  # 스택의 뒤쪽이 폭탄 문자열과 동일한지 검사
  if len(stack) >= bl:
    if ''.join(stack[-bl:]) == bomb:
      del stack[-bl:]  # 폭발!

result = ''.join(stack)
print(result if result else "FRULA")