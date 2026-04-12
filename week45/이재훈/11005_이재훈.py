N, B = map(int, input().split())

res = []
while N > 0:
  digit = N % B
  N //= B
  
  if digit >= 10:
    digit = chr(ord('A') + digit - 10)
  else:
    digit = str(digit)
  
  res.append(digit)

print(''.join(reversed(res)))